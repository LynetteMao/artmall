
package com.artmall.config;

import com.artmall.pojo.Business;
import com.artmall.utils.JsonUtils;
import com.artmall.utils.Tools;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.tools.Tool;
import java.util.UUID;
import java.util.concurrent.TimeUnit;




/**
 * @author 生成token（发送邮件标识用户身份的token）
 * @create 2018-08-24 10:43
 **/

@Component
public class RedisTokenManager {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    private String signUpPrefix="http://localhost:8080/";

    public String getTokenOfSignUp(Business business){
        String token = UUID.randomUUID().toString();
        //将token和business以键值对的形式存放至redis
        redisTemplate.opsForValue().set(token,business);
        //设置在redis里面的过期时间
        redisTemplate.expire(token,30,TimeUnit.MINUTES);

        return token;
    }

    public String getCodeOfResetPassword(Business business){
        String code = Tools.getRandomNum();
        redisTemplate.opsForValue().set(code,business);
        redisTemplate.expire(code,30,TimeUnit.HOURS);
        return code;
    }

    public Business getBusiness(String token) {
        Business business=(Business) redisTemplate.opsForValue().get(token);
        return business;
    }
}

