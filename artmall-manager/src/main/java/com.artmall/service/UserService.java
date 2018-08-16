package com.artmall.service;

import com.artmall.pojo.Role;

import java.util.Set;

public interface UserService {
    Set<String> getRoles(Long id);

    Set<String> getPermissions(Long id);
}
