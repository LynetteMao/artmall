package com.artmall.service;

import com.artmall.pojo.NewProject;
import org.springframework.web.multipart.MultipartFile;

public interface NewProjectService {
    public Boolean  uploadNewProject(NewProject newProject, MultipartFile[] multipartFiles);
}
