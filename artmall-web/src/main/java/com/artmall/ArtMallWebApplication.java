package com.artmall;

import com.artmall.storage.StorageProperties;
import com.artmall.service.StorageService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "com.artmall")
@MapperScan(basePackages = "com.artmall.mapper")
@EnableConfigurationProperties(StorageProperties.class)
public class ArtMallWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtMallWebApplication.class, args);
    }
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
//            storageService.deleteAll();
            storageService.init();
        };
    }
}

