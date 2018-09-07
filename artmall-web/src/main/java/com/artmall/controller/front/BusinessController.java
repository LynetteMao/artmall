package com.artmall.controller.front;


import com.artmall.config.RedisTokenManager;
import com.artmall.email.EmailService;
import com.artmall.pojo.Business;
import com.artmall.response.Const;
import com.artmall.response.ServerResponse;
import com.artmall.service.BusinessService;
import com.artmall.service.StorageService;
import com.artmall.utils.JWTUtil;
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
    public ServerResponse resiger(@RequestBody Business business){


        String email = business.getEmail();
        if (businessService.selectBusinessByEmail(email)!=null){
            return ServerResponse.Failure("用户已注册");
        }else {
            Business newBusiness = businessService.register(business);
            return sendValidateEmail(newBusiness);
        }
    }


    /**
     * 发送验证邮件
     * @param business
     */

        private ServerResponse sendValidateEmail(Business business){
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
    @RequestMapping(value = "/register/verify")
    public ServerResponse verify (@RequestParam("token") String token,
                                  @RequestParam("id") Long id){
        //如果验证成功要从redis中获取数据存入数据库
        if (emailService.userValidate(id,token)) {
            Business business=redisTokenManager.getBusiness(token);
            return businessService.addUser(business);
        }
        else
            return ServerResponse.Failure("verify failure");

    }

//    private  ServerResponse checkSignUp(Business business){
//        if (!CheckUtils.isEmail(business.getEmail())){
//            return ServerResponse.Failure("")
//        }
//    }

    /**
     * 注册时上传工商管理证明
     * @param file
     * @param id
     * @return
     */
    @ApiOperation("上传凭证")
    @RequestMapping(value = "/register/upload",method = RequestMethod.POST)
    public ServerResponse upload (@RequestParam("file")MultipartFile file,
                                          @RequestParam("businessid")Long id){
        return storageService.addInfoAttachment(file,id);
    }

    /**
     * 企业登录
     * @param email
     * @param password
     * @return
     */
    @ApiOperation("企业登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse login (@RequestParam("email")String email,
                                           @RequestParam("password")String password){
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
     * @param email
     * @return
     */
    @ApiOperation("忘记密码")
    @RequestMapping(value = "/forget",method = RequestMethod.POST )
    public ServerResponse forget (@RequestParam("email") String email){
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
     * @param email
     * @param code
     * @param newPassword
     * @return
     */
    @ApiOperation("重置密码")
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST )
    public ServerResponse resetPassword (@RequestParam("email")String email,
                                         @RequestParam("code") String code,
                                         @RequestParam("newPassword") String newPassword ){
        Business business = businessService.selectBusinessByEmail(email);
        if (emailService.codeVerify(business,code)){
            return businessService.resetPassword(business,newPassword);
        }else{
            return ServerResponse.Failure("验证码错误");
        }
    }






}
