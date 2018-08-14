package com.artmall;

import com.artmall.pojo.Student;
import com.artmall.service.StudentService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/** 
* StudentServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"com.artmall"})
public class StudentServiceImplTest { 

@Test
public void testSelectStudentById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addUser(Student student) 
* 
*/
@Resource(name = "StudentService")
    StudentService studentService;
@Test
public void testAddUser() throws Exception { 
//TODO: Test goes here...
    Student student = new Student();
    student.setStudentId("20162590");
    student.setHashedPwd("123456");
    student.setLoginName("lalala");
    System.out.println(studentService.addUser(student));
} 

/** 
* 
* Method: selectStudentByStuId(String userNo) 
* 
*/ 
@Test
public void testSelectStudentByStuId() throws Exception { 
//TODO: Test goes here... 
} 


} 
