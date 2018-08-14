package com.artmall.Impl;



import com.artmall.mapper.StudentMapper;
import com.artmall.pojo.Student;
import com.artmall.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2018-08-08 13:51
 **/
@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService {


    @Autowired
    Student student;
    @Autowired
    StudentMapper studentMapper;


//    @Override
//    public List<Student> getAll() {
//        return studentMapper.selectAll();
//    }

    @Override
    public Student selectStudentById(Long id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @Override
    public void addUser(Student student) {
        studentMapper.insert(student);
    }
}
