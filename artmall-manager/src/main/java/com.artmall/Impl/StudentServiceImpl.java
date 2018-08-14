package com.artmall.Impl;



import com.artmall.mapper.StudentMapper;
import com.artmall.pojo.Student;
import com.artmall.pojo.StudentExample;
import com.artmall.response.ServerResponse;
import com.artmall.service.StudentService;
import com.artmall.utils.IDUtils;
import com.artmall.utils.MD5;
import com.artmall.utils.SaltUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public ServerResponse<Student> addUser(Student student) {
        Student newStudent = new Student();
        newStudent.setId(IDUtils.getProjectId());
        newStudent.setStudentId(student.getStudentId());
        newStudent.setSalt(SaltUtil.InitSalt());
        newStudent.setHashedPwd(new SimpleHash("MD5",student.getHashedPwd(),ByteSource.Util.bytes(student.getSalt()),1024).toString());
        newStudent.setGmtCreate(new Date());
        newStudent.setIsVerified((byte) 0);
        newStudent.setLoginName(student.getLoginName());
        try {
            studentMapper.insert(newStudent);
        }catch (Exception e){
            return ServerResponse.Failure("插入失败",newStudent);
        }

        return ServerResponse.createBySuccess("插入成功");
    }

    @Override
    public Student selectStudentByStuId(String userNo) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(userNo);
        List<Student> list = studentMapper.selectByExample(example);
        return list.get(0);
    }
}
