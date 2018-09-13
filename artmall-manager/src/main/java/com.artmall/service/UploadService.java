package com.artmall.service;

import com.artmall.pojo.BusinessAttachment;
import com.artmall.response.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * @author mllove
 * @create 2018-09-11 19:37
 **/

public interface UploadService  {
    BusinessAttachment addBusinessAttachmentInfoToRedis(MultipartFile []file, Long id);

    ServerResponse addBusinessAttachmentInfo(BusinessAttachment businessAttachment);

    ServerResponse addProjectAttachmentInfo(MultipartFile[] files,Long id);

    ServerResponse addWorksAttachmentInfo(MultipartFile[] files, Long worksId,MultipartFile showfile);
}
