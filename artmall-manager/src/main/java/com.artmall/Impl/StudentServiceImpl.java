package com.artmall.Impl;



import com.artmall.mapper.StudentMapper;
import com.artmall.pojo.Student;
import com.artmall.pojo.StudentExample;
import com.artmall.response.ServerResponse;
import com.artmall.service.StudentService;
import com.artmall.utils.IDUtils;
import com.artmall.utils.JWTUtil;
import com.artmall.utils.MD5;
import com.artmall.utils.SaltUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author
 * @create 2018-08-08 13:51
 **/
@CacheConfig(cacheNames = "stu")     //抽取缓存的公共配置
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
    @CachePut
    public Student selectStudentById(Long id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @Override
    public ServerResponse<Student> addUser(Student student) {
        Student newStudent = new Student();
        newStudent.setId(IDUtils.getIdUtils().nextId());
        newStudent.setStudentId(student.getStudentId());
        newStudent.setSalt(SaltUtil.InitSalt());
        newStudent.setHashedPwd(new SimpleHash("MD5",student.getHashedPwd(),ByteSource.Util.bytes(newStudent.getSalt()),1024).toString());
        newStudent.setGmtCreate(new Date());
        newStudent.setIsVerified((byte) 0);
        newStudent.setLoginName(student.getLoginName());
        try {
            studentMapper.insert(newStudent);
        }catch (Exception e){
            return ServerResponse.Failure("插入失败");
        }

        return ServerResponse.Success("插入成功");
    }

    @Override
    public Student selectStudentByStuId(String userNo) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(userNo);
        List<Student> list = studentMapper.selectByExample(example);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public ServerResponse<Student> resetPassword(String newpassword) {
        Subject subject = SecurityUtils.getSubject();
        String token = (String) subject.getPrincipal();
        Long id = JWTUtil.getUserNo(token);
        Student student = studentMapper.selectByPrimaryKey(id);
        student.setHashedPwd(new SimpleHash("MD5",newpassword,ByteSource.Util.bytes(student.getSalt()),1024).toString());
        student.setIsVerified(Byte.valueOf("1"));
        try {
            studentMapper.updateByPrimaryKey(student);
        }catch (Exception e){
            return ServerResponse.Failure("修改密码");
        }

        return ServerResponse.Success("修改密码成功",student);
    }
}
