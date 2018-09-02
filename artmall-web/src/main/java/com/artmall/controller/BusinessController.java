package com.artmall.controller;

import com.artmall.RedisTokenManager;
import com.artmall.email.EmailService;
import com.artmall.pojo.Business;
import com.artmall.response.Const;
import com.artmall.response.ServerResponse;
import com.artmall.service.BusinessService;
import com.artmall.service.StorageService;
import com.artmall.utils.CheckUtils;
import com.artmall.utils.JWTUtil;
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
    @RequestMapping(value = "/register",method = RequestMethod.POST)

    public ServerResponse resiger(@RequestBody Business business){


        String email = business.getEmail();
//        if (businessService.selectBusinessByEmail(email)!=null){
//            return ServerResponse.Failure("用户已注册");
//        }
        sendValidateEmail(business);
        return businessService.addUser(business);
//                emailService.registerEmail(business,token);
    }

    private void sendValidateEmail(Business business){
        System.out.println("test");
        String token =redisTokenManager.getTokenOfSignUp(business);
        System.out.println("TOKEN:"+token);
        System.out.println("The business sign in ,so we send the email!!!");
        emailService.test(business,token);
        emailService.userValidate(business,token);
    }

//    private  ServerResponse checkSignUp(Business business){
//        if (!CheckUtils.isEmail(business.getEmail())){
//            return ServerResponse.Failure("")
//        }
//    }
    @RequestMapping(value = "/register/upload",method = RequestMethod.POST)
    public ServerResponse upload (@RequestParam("file")MultipartFile file,
                                          @RequestParam("businessid")Long id){
        return storageService.addInfoAttachment(file,id);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse login (@RequestParam("email")String email,
                                           @RequestParam("password")String password){
        UsernamePasswordToken token = new UsernamePasswordToken(email,password);
        Business business = businessService.selectBusinessByEmail(email);
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
    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/forget",method = RequestMethod.POST )
    public ServerResponse forget (@RequestParam("email") String email){
        System.out.println("email为"+businessService.selectBusinessByEmail(email).getEmail());
        if(businessService.selectBusinessByEmail(email)!=null){
            return emailService.sendSimpleMail(email,"我应该会成功的","hello world!");
        }else {
            return ServerResponse.Failure("此email没有注册");
        }

    }








}
