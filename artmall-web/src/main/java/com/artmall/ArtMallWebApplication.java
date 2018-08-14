package com.artmall;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com.artmall")
@MapperScan(basePackages = "com.artmall.mapper")
public class ArtMallWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtMallWebApplication.class, args);
    }
}
