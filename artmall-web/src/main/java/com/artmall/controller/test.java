package com.artmall.controller;



import com.artmall.pojo.Student;
import com.artmall.response.ServerResponse;
import com.artmall.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ServerResponse<Student> getStudentName(){
        Long id = Long.valueOf(2222);
        return studentService.selectStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAll()
    {
        return studentService.getAll();
    }
}
