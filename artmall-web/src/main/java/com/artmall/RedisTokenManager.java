package com.artmall;

import com.artmall.pojo.Business;
import com.artmall.utils.JsonUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 生成token（发送邮件标识用户身份的token）
 * @create 2018-08-24 10:43
 **/
@Component
public class RedisTokenManager {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    private String signUpPrefix="http://123";
    public String getTokenOfSignUp(Business business){
        System.out.println("I am here");
        String token = UUID.randomUUID().toString();
        System.out.println("token:"+token);
        String value = JsonUtils.objectToJson(business);
        redisTemplate.opsForValue().set(token,value);
        System.out.println("haskey?"+redisTemplate.boundListOps(token).toString());
        redisTemplate.expire(token,12,TimeUnit.HOURS);

        return token;
    }

}
