package com.artmall.service;


import com.artmall.pojo.Business;

public interface BusinessService {
    Business selectBusinessByEmail(String email);

    Business selectBusinessById(Long userNo);
}
