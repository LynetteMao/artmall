package com.artmall.service;


import com.artmall.pojo.Business;
import com.artmall.response.ServerResponse;

public interface BusinessService {
    Business selectBusinessByEmail(String email);

    Business selectBusinessById(Long userNo);

    ServerResponse<Business> addUser(Business business);
}
