package com.artmall.service;

import com.artmall.response.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传和下载
 */
public interface StorageService {
    void init();

    String store(MultipartFile file);

    void deleteAll();

    ServerResponse<Object> addInfoAttachment(MultipartFile file,Long id);

}
