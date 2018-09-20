
package com.artmall.Impl;

import com.artmall.mapper.BidMapper;
import com.artmall.mapper.ProjectAttachmentMapper;
import com.artmall.mapper.ProjectMapper;
import com.artmall.pojo.*;
import com.artmall.service.BusinessService;
import com.artmall.service.ProjectService;
import com.artmall.utils.DateUtil;
import com.artmall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

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

    @Override
    public Project selectById(Long projectId) {
        Project project= projectMapper.selectByPrimaryKey(projectId);
        return project;
    }

    @Autowired
    BidMapper bidMapper;
    @Override
    public Project selectProjectInfo(Project project) {
        List<Bid> bidList = getBidByProjectId(project.getId());
        project.setBidCount(bidList.size());
        return project;
    }

    @Override
    public void deadProject(Project project) {
        project.setIsVerified(Byte.valueOf("2"));
        projectMapper.updateByPrimaryKey(project);
    }

    private List getBidByProjectId(Long id) {
        BidExample example = new BidExample();
        BidExample.Criteria criteria = example.createCriteria();
        criteria.andProjectIdEqualTo(id);
        List list = bidMapper.selectByExample(example);
        return list;
    }
}

