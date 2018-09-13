package com.artmall.controller.front;

import com.artmall.config.RedisTokenManager;
import com.artmall.email.EmailService;
import com.artmall.pojo.Student;
import com.artmall.response.Const;
import com.artmall.response.ServerResponse;
import com.artmall.service.StudentService;
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
    @ApiOperation("学生登录，如果是第一次登录，则返回1111")
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


    @Autowired
    RedisTokenManager redisTokenManager;
    @Autowired
    EmailService emailService;
    /**
     * 发送重置密码验证码的邮件
     * @param student
     * @return
     */
    @ApiOperation("发送重置密码验证码的邮件")
    private ServerResponse sendResetPasswordEmail(Student student){
        String code =redisTokenManager.getCodeOfResetPassword(student);
        if (student.getEmail()!=null) {
            return emailService.sendResetEmail(student, code);
        }else
            return ServerResponse.Failure("请在第一次登录后验证邮箱");
    }

    /**
     * 忘记密码
     * @return
     */
    @ApiOperation("忘记密码")
    @RequestMapping(value = "/forget",method = RequestMethod.POST)
    public ServerResponse forget (@RequestParam("stuId") String studId){
        Student student = studentService.selectStudentByStuId(studId);
        if (student != null){
            return sendResetPasswordEmail(student);
        }else {
            return ServerResponse.Failure("没有此学生");
        }
    }


    /**
     * 第一次登入时填入邮箱修改密码
     * @param email
     * @return
     */
    @ApiOperation("第一次登录时填入邮箱修改密码")
    @RequestMapping(value = "/firstLogin/SendEmail",method = RequestMethod.POST)
    public ServerResponse firstLogin (@RequestParam("email")String email){
        Student student=studentService.getStudent();
        student.setEmail(email);
        return sendResetPasswordEmail(student);
    }

    @ApiOperation("邮件验证码验证")
    @RequestMapping(value = "/firstLogin/verified",method = RequestMethod.POST)
    public ServerResponse firstLoginVeried(@RequestParam("email")String email,
                                           @RequestParam("code") String code,
                                           @RequestParam("newPassword") String newPassword){
        Student student = studentService.getStudent();
        if (emailService.codeVerify(student,code)){
            return studentService.resetPassword(email,newPassword);
        }else {
            return ServerResponse.Failure("验证码错误");
        }

    }

    /**
     * 修改密码
     * @param email
     * @param code
     * @param newPassword
     * @return
     */
    @ApiOperation("修改密码")
    @RequestMapping(value = "/resetPasswordByEmail",method = RequestMethod.POST)
    public ServerResponse resetPassword (@RequestParam("email")String email,
                                         @RequestParam("code") String code,
                                         @RequestParam("newPassword") String newPassword){
        Student student = studentService.selectStudentByEmail(email);
        if (emailService.codeVerify(student,code)){
            return studentService.resetPasswordByEmail(student,newPassword);
        }else{
            return ServerResponse.Failure("验证码错误");
        }
    }


/*    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ServerResponse article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return ServerResponse.Success("You are already logged in");
        } else {
            return ServerResponse.Failure( "You are guest");
        }

    }*/









}
