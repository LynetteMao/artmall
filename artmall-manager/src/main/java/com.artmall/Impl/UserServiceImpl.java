package com.artmall.Impl;

import com.artmall.mapper.RoleMapper;
import com.artmall.mapper.UserMapper;
import com.artmall.pojo.Role;
import com.artmall.pojo.Student;
import com.artmall.pojo.StudentExample;
import com.artmall.pojo.User;
import com.artmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author
 * @create 2018-08-15 17:50
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public Set<String> getRoles(Long id) {
        return userMapper.getRoles(id);
    }

    @Override
    public Set<String> getPermissions(Long id) {

        return userMapper.getPermissions(id);
    }
}
