package com.artmall.controller;



import com.artmall.pojo.Student;
import com.artmall.response.ServerResponse;
import com.artmall.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author
 * @create 2018-08-11 16:08
 **/
@RestController
public class test {
    private final static Logger log = LoggerFactory.getLogger(test.class);
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/hello" )
    public String test (){
        log.debug("ewwwwwww");
        return "hello world!";
    }

    @RequestMapping(value = "/info" )
    public Student getStudentName(){
        Student student = studentService.selectStudentByStuId("20162590");
        return student;
    }

    @RequestMapping(value = "/register" )
    public ServerResponse<Student> signin (){

        Student student = new Student();
        student.setStudentId("20162570");
        student.setHashedPwd("123456");
        student.setLoginName("最后一次尝试");
        return studentService.addUser(student);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST )
    public ServerResponse<Student> login (){
        String studentId = "20162570";
        String password = "123456";
        UsernamePasswordToken token = new UsernamePasswordToken(studentId,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            System.out.println("进行登入验证");
            subject.login(token);
        }catch (Exception e){
            return ServerResponse.loginFailure("登入失败");
        }


        return ServerResponse.loginSuccess("登入成功");

    }
    //没有session，所以无法测试，无法保存登入状态
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ServerResponse<Student> logout (){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        log.debug("logout");
        return ServerResponse.loginSuccess("logout成功");

    }

//    @GetMapping("/all")
//    public List<Student> getAll()
//    {
//        return studentService.getAll();
//    }
}
