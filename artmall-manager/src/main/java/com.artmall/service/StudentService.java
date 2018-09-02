package com.artmall.service;




import com.artmall.pojo.Student;
import com.artmall.response.ServerResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author
 * @create 2018-08-06 10:38
 **/

public interface StudentService {


//    List<Student> getAll();

   Student selectStudentById(Long id);

    ServerResponse<Student> addUser(Student student);

    Student selectStudentByStuId(String userNo);

    ServerResponse<Student> resetPassword(String newpassword);
}
