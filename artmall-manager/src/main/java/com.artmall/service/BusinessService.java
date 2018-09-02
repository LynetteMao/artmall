package com.artmall.service;


import com.artmall.pojo.Business;
import com.artmall.pojo.BusinessAttachment;
import com.artmall.response.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

public interface BusinessService {
    Business selectBusinessByEmail(String email);

    Business selectBusinessById(Long userNo);

    ServerResponse<Business> addUser(Business business);




}
