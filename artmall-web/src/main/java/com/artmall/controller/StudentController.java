package com.artmall.controller;

import com.artmall.pojo.Student;
import com.artmall.response.Const;
import com.artmall.response.ServerResponse;
import com.artmall.service.StudentService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mllove
 * @create 2018-08-20 10:08
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    private final static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse login (@RequestParam("studentid")String studentId,
                                          @RequestParam("password")String password){
        UsernamePasswordToken token = new UsernamePasswordToken(studentId,password);
        Student student = studentService.selectStudentByStuId(studentId);
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
        //如果是第一次登入，由前端控制路由跳转
        byte verified = 0;
        if (student.getIsVerified().equals(verified)){
            return ServerResponse.FirstSuccess(JWTUtil.sign(student.getId(),Const.LoginType.STUDENT));
        }else
            return ServerResponse.Success(JWTUtil.sign(student.getId(),Const.LoginType.STUDENT));
    }



    //要登入后的用户才能更改
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    public ServerResponse resetPassword (@RequestParam ("password") String newpassword){
        return studentService.resetPassword(newpassword);
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ServerResponse article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return ServerResponse.Success("You are already logged in");
        } else {
            return ServerResponse.Failure( "You are guest");
        }
    }









}
