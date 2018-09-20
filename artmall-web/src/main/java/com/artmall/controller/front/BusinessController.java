package com.artmall.controller.front;


import com.artmall.Dto.RegisterDto;
import com.artmall.captcha.CaptchaService;
import com.artmall.config.RedisTokenManager;
import com.artmall.email.EmailService;
import com.artmall.pojo.Business;
import com.artmall.pojo.BusinessAttachment;
import com.artmall.response.Const;
import com.artmall.response.ServerResponse;
import com.artmall.service.BusinessService;
import com.artmall.service.StorageService;

import com.artmall.service.UploadService;
import com.artmall.utils.JWTUtil;
import com.artmall.utils.SendCaptchaUtils;
import com.github.qcloudsms.SmsSingleSenderResult;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.util.Map;

/**
 * @author mllove
 * @create 2018-08-20 10:08
 **/
@RestController
@RequestMapping("/business")
public class BusinessController {
    private final static Logger log = LoggerFactory.getLogger(BusinessController.class);
    @Autowired
    BusinessService businessService;
    @Autowired
    StorageService storageService;
    @Autowired
    private RedisTokenManager redisTokenManager;
    @Autowired
    EmailService emailService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ApiOperation("注册")
    public ServerResponse resiger(@RequestBody RegisterDto business){


        String email = business.getMail();
        if (businessService.selectBusinessByEmail(email)!=null){
            return ServerResponse.Failure("用户已注册");
        }else {
            Business newBusiness = businessService.register(business);

            sendValidateEmail(newBusiness);
            return ServerResponse.Success("发送成功",newBusiness);
        }
    }

    @Autowired
    CaptchaService captchaService;
    /**
     * 发送验证短信
     * @param
     * @return
     */
    @ApiOperation("发送验证码")
    @RequestMapping(value = "/register/captcha",method = RequestMethod.POST)
    public SmsSingleSenderResult sendCaptcha  (HttpServletRequest request){
        String tel = request.getParameter("tel");
        return captchaService.sendCaptcha(tel);
    }

    @ApiOperation("验证手机和验证码是否匹配")
    @RequestMapping(value = "/register/captcha/varify",method = RequestMethod.POST)
    public ServerResponse varifyCaptcha  (HttpServletRequest request){
        String tel = request.getParameter("tel");
        String code = request.getParameter("code");
        if (captchaService.captchaValidate(tel,code))
            return ServerResponse.Success("验证成功");
        else
            return ServerResponse.Failure("验证失败");
    }





    /**
     * 发送验证邮件
     * @param business
     */

        private ServerResponse sendValidateEmail(Business business){
            //写入缓存
            String token =redisTokenManager.getTokenOfSignUp(business);
            return emailService.registerEmail(business,token);
        }
    /**
     * 核对用户点击的链接是否有效
     * @param token
     * @param id
     * @return
     */
    @ApiOperation("验证链接")
    @RequestMapping(value = "/register/verify",method = RequestMethod.GET)
    public ServerResponse verifyEmail (@RequestParam("token") String token,
                                  @RequestParam("id") Long id){
        //如果验证成功要从redis中获取数据存入数据库
        if (emailService.userValidate(id,token)) {
            //读取缓存
            Business business=redisTokenManager.getBusiness(token);
            businessService.addUser(business);
            //从缓存中将附件信息写入数据库
            BusinessAttachment businessAttachment = redisTokenManager.getBusinessAttachment(business.getId());
            uploadService.addBusinessAttachmentInfo(businessAttachment);
            return ServerResponse.Success("注册成功");
        }
        else
            return ServerResponse.Failure("verify failure");

    }


    /**
     * 注册时上传工商管理证明
     * @param file
     * @param
     * @return
     */
    @Autowired
    UploadService uploadService;
    @ApiOperation("上传凭证")
    @RequestMapping(value = "/register/upload",method = RequestMethod.POST,headers = "Content-Type= multipart/form-data")
    public ServerResponse upload (@RequestParam("file")MultipartFile []file,
                                  @RequestParam("id")Long id,
                                  @RequestBody Map<String,String> map){
        MultipartFile[] files = map.get("file");


        BusinessAttachment businessAttachment =uploadService.addBusinessAttachmentInfoToRedis(file,id);
        redisTokenManager.setBusinessAttachmentRedis(businessAttachment);
        return ServerResponse.Success("上传成功");
    }


    /**
     * 企业登录
     * @param
     * @param
     * @return
     */
    @ApiOperation("企业登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse login (@RequestBody Map<String,String> map){
            String email = map.get("email");
            String password = map.get("password");

        UsernamePasswordToken token = new UsernamePasswordToken(email,password);
        Business business = businessService.selectBusinessByEmail(email);
        if (business.getIsVerified()!=3)
            return ServerResponse.Failure("审核还未通过");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (UnknownAccountException uae){
            return ServerResponse.Failure("用户不存在");
        }catch (IncorrectCredentialsException ice) {
            return ServerResponse.Failure("信息不匹配");
        }catch (AuthenticationException ae){
            return ServerResponse.Failure("error");
        }

        return ServerResponse.Success(JWTUtil.sign(business.getId(),Const.LoginType.BUSINESS));
    }
    /**
     * 忘记密码
     * @param
     * @return
     */
    @ApiOperation("忘记密码")
    @RequestMapping(value = "/forget",method = RequestMethod.POST )
    public ServerResponse forget (@RequestBody Map<String,String> map){
        String email = map.get("email");
        Business business = businessService.selectBusinessByEmail(email);

        if(business!=null){
            return sendResetPasswordEmail(business);
        }else {
            return ServerResponse.Failure("此email没有注册");
        }

    }

    /**
     * 发送重置密码验证码的邮件
     * @param business
     * @return
     */
    private ServerResponse sendResetPasswordEmail(Business business){
        String code =redisTokenManager.getCodeOfResetPassword(business);
        return emailService.sendResetEmail(business,code);
    }


    /**
     * 重置密码
     * @return
     */
    @ApiOperation("重置密码")
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST )
    public ServerResponse resetPassword (@RequestBody Map<String,String> map){
        String email = map.get("email");
        String code = map.get("code");
        String newPassword = map.get("newPassword");

        Business business = businessService.selectBusinessByEmail(email);
        if (emailService.codeVerify(business,code)){
            return businessService.resetPassword(business,newPassword);
        }else{
            return ServerResponse.Failure("验证码错误");
        }
    }






}
