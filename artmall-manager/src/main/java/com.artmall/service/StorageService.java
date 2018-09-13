package com.artmall.service;

import com.artmall.response.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件上传和下载
 */
public interface StorageService {
    void init();

    String store(MultipartFile file, Path path);

    void deleteAll();

    Path[] fileUpload(String path_sign, MultipartFile []file);

//    ServerResponse<Object> addInfoAttachment(MultipartFile file,Long id);
    Path makeWatermarkPath(String path_sign, String filename);

    Path makeImageDirectoryPath(String pathSign, String originalFilename);
}
