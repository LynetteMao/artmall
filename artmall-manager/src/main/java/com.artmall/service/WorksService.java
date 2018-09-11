package com.artmall.service;

import com.artmall.pojo.Works;
import org.springframework.web.multipart.MultipartFile;

public interface WorksService {
    public Boolean  uploadWorks(Works work, MultipartFile[] multipartFiles);
}
