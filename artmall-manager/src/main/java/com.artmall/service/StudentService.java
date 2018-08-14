package com.artmall.service;




import com.artmall.pojo.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author
 * @create 2018-08-06 10:38
 **/

public interface StudentService {


//    List<Student> getAll();

   Student selectStudentById(Long id);

    void addUser(Student student);
}
