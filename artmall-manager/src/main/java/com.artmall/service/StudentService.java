package com.artmall.service;


import com.artmall.pojo.Student;
import com.artmall.response.ServerResponse;

import java.util.List;

/**
 * @author
 * @create 2018-08-06 10:38
 **/

public interface StudentService {


    List<Student> getAll();

    ServerResponse<Student> selectStudentById(Long id);
}
