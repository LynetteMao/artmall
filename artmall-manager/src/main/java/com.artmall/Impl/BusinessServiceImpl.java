package com.artmall.Impl;

import com.artmall.pojo.Business;

import com.artmall.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @create 2018-08-08 14:10
 **/
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    Business business;
    @Override
    public Business selectBusinessByEmail(String email) {
        return null;
    }

    @Override
    public Business selectBusinessById(Long userNo) {
        return null;
    }
}
