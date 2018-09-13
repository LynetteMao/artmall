
package com.artmall.Impl;

import com.artmall.mapper.ProjectAttachmentMapper;
import com.artmall.mapper.ProjectMapper;
import com.artmall.pojo.Business;
import com.artmall.pojo.Project;
import com.artmall.pojo.ProjectAttachment;
import com.artmall.pojo.ProjectAttachmentExample;
import com.artmall.service.BusinessService;
import com.artmall.service.ProjectService;
import com.artmall.utils.DateUtil;
import com.artmall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    BusinessService businessService;
    @Autowired
    ProjectMapper projectMapper;
    @Override
    public Project addProject(Project project) {
        Project newProject = new Project();
        Business business = businessService.getBusiness();
        if (business==null)
            return null;
        newProject.setId(new IDUtils(2,5).nextId());
        newProject.setBusinessId(business.getId());
        newProject.setProjectName(project.getProjectName());
        newProject.setProjectDescription(project.getProjectDescription());
        newProject.setIsVerified(Byte.valueOf("0"));
        newProject.setBudget(project.getBudget());
        newProject.setTenderPeriod(project.getTenderPeriod());
        newProject.setExpectedTime(project.getExpectedTime());
        newProject.setGmtCreate(new Date());
        newProject.setGmtModified(new Date());
        newProject.setFollowerCount(0);
        newProject.setSkillList(project.getSkillList());
        System.out.println(newProject.getSkillList());
        try{
            projectMapper.insert(newProject);
            return newProject;
        }catch (Exception e){
            return null;
        }
    }
}

