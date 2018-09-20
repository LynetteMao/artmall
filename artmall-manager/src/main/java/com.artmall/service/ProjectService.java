package com.artmall.service;

import com.artmall.pojo.Project;
import org.springframework.web.multipart.MultipartFile;

public interface ProjectService {
    Project addProject(Project project);

    Project selectById(Long projectId);

    Project selectProjectInfo(Project project);

    void deadProject(Project project);
}
