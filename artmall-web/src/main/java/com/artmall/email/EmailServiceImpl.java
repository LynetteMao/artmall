package com.artmall.email;

import com.artmall.RedisTokenManager;
import com.artmall.pojo.Business;
import com.artmall.response.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author
 * @create 2018-08-22 15:15
 **/
@Service
public class EmailServiceImpl implements EmailService {
    private final static Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);


    private static final String TITLE_SIGN_UP = "[邮件标题]";

    private static final String CONTENT = "[邮件内容]";
    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String from;


    @Override
    public ServerResponse sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
//        try {
            emailSender.send(message);
            return ServerResponse.Success("邮件已发送");
//        }catch (Exception e){
//            return ServerResponse.Failure("邮件发送失败");
//        }
    }
    public  void test(Business business,String token){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(business.getEmail());
        message.setSubject("验证邮件");
        String link = "http://localhost:8080"+token;
        String mes=String.format(CONTENT,business.getBusinessName(),link,link);
        message.setText(link);
        emailSender.send(message);
        System.out.println("have send");
    }

    @Override
    public void registerEmail(Business business, String token) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"GBK");
            helper.setFrom(from);
            helper.setTo(business.getEmail());
            helper.setSubject(TITLE_SIGN_UP);
            String link = "http://localhost:8080/"+token;
            String message = String.format(CONTENT,business.getBusinessName(),link,link);
            emailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("发送邮件失败");
        }
    }

    @Autowired
    RedisTokenManager redisTokenManager;
    @Override
    public void userValidate(Business business, String token) {

    }
}
