package com.artmall.Impl;

import com.artmall.mapper.NewProjectAttachmentMapper;
import com.artmall.mapper.NewProjectMapper;
import com.artmall.pojo.NewProject;
import com.artmall.pojo.NewProjectAttachment;
import com.artmall.pojo.NewProjectAttachmentExample;
import com.artmall.pojo.NewProjectExample;
import com.artmall.service.NewProjectService;
import com.artmall.utils.DateUtil;
import com.artmall.utils.FileUtils;
import com.artmall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.WebSocketContainer;
import java.util.List;

@Service
public class NewProjectServiceImpl implements NewProjectService{

    @Autowired
    private NewProjectMapper newProjectMapper;

    @Autowired
    private NewProjectAttachmentMapper newProjectAttachmentMapper;

    @Override
    public Boolean uploadNewProject(NewProject newProject, MultipartFile[] multipartFiles) {
        String[] allPath = FileUtils.upFile(multipartFiles);
        if (allPath == null) {
            //ServerResponse<Integer>.Failure("上传失败");
            return false;
        }
        int res = newProjectMapper.insert(newProject);
        Boolean tF = uploadNewProjectAttachment(allPath, multipartFiles, newProject.getId());
        if (res <= 0 || !tF) {
            FileUtils.deleteFiles(allPath);
            if (res <= 0) newProjectMapper.deleteByPrimaryKey(newProject.getId());
            return false;
        }
        return true;
    }

    private Boolean uploadNewProjectAttachment(String[] allPath, MultipartFile[] multipartFiles, Long projectId) {
        int len = multipartFiles.length;
        NewProjectAttachment[] newProjectAttachments = new NewProjectAttachment[len];
        for (int i = 0; i < len; i++) {
            MultipartFile mult = multipartFiles[i];
            newProjectAttachments[i] = new NewProjectAttachment();
            NewProjectAttachment newProjectAttachment = newProjectAttachments[i];
            newProjectAttachment.setId(new IDUtils(7,8).nextId());
            newProjectAttachment.setAttachment_name(mult.getOriginalFilename());
            newProjectAttachment.setAttachment_size(mult.getSize());
            newProjectAttachment.setAttachment_path(allPath[i]);
            newProjectAttachment.setProject_id(projectId);
            newProjectAttachment.setGmt_create(DateUtil.getDate());
            newProjectAttachment.setGmt_modified((DateUtil.getDate()));
            int res = newProjectAttachmentMapper.insert(newProjectAttachment);

            if (res <= 0) {
                for (int j = i - 1; j >= 0; j--) {
                    NewProjectAttachmentExample ex = new NewProjectAttachmentExample();
                    NewProjectAttachmentExample.Criteria criteria = ex.createCriteria();
                    criteria.andProject_idEqualTo(projectId);
                    newProjectAttachmentMapper.deleteByExample(ex);
                }
                return false;
            }
        }
        return true;
    }
}
