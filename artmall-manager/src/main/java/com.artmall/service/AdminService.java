package com.artmall.service;

import com.artmall.pojo.Admin;
import com.artmall.pojo.UserMember;
import com.artmall.response.ServerResponse;

/**
 * @author
 * @create 2018-08-20 8:52
 **/

public interface AdminService {
    Admin selectByUsername(String username);

    ServerResponse<Admin> addUser(Admin admin);

    Admin selectByUserId(Long userid);
}
