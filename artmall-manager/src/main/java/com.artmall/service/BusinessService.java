package com.artmall.service;


import com.artmall.pojo.Business;
import com.artmall.pojo.BusinessAttachment;
import com.artmall.pojo.Student;
import com.artmall.response.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

public interface BusinessService {
    Business selectBusinessByEmail(String email);

    Business selectBusinessById(Long id);

    ServerResponse<Business> addUser(Business business);

    Business register(Business business);


    ServerResponse resetPassword(Business business,String newPassword);

    ServerResponse emailSuccess(Business business);
}
