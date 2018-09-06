package com.artmall.email;

import com.artmall.pojo.Business;
import com.artmall.response.ServerResponse;

/**
 * @author
 * @create 2018-08-22 15:15
 **/

public interface EmailService {
//    public ServerResponse sendSimpleMail(String to,String subject,String content);

    public ServerResponse registerEmail(Business business,String token);

     Boolean userValidate(Long id, String token);


    ServerResponse sendResetEmail(Business business,String code);

    boolean codeVerify(Business business, String code);
//     ServerResponse test(Business business,String token);
}
