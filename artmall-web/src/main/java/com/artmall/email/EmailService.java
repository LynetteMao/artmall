package com.artmall.email;

import com.artmall.pojo.Business;
import com.artmall.response.ServerResponse;

/**
 * @author
 * @create 2018-08-22 15:15
 **/

public interface EmailService {
    public ServerResponse sendSimpleMail(String to,String subject,String content);

    public void registerEmail(Business business,String token);

    void userValidate(Business business, String token);
     void test(Business business,String token);
}
