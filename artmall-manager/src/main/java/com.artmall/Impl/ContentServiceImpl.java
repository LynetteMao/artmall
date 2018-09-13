package com.artmall.Impl;

import com.artmall.mapper.*;
import com.artmall.pojo.*;
import com.artmall.response.ServerResponse;
import com.artmall.service.ContentService;
import com.artmall.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.sun.tracing.dtrace.ArgsAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mllove
 * @create 2018-09-10 10:36
 **/
@Service
public class ContentServiceImpl implements ContentService {

    private final static Logger log = LoggerFactory.getLogger(ContentService.class);
//    @Autowired
//    WorksMapper worksMapper;
//
//    @Override
//        public List<Works> getHome(int page,int rows) {
//            PageHelper.startPage(page,rows);
//            List<Works> list = new ArrayList<>();
//            list = worksMapper.getTop();
//            for (Works element: list ){
//                List<WorksAttachment> worksAttachments = new ArrayList<>();
//                worksAttachments=  getAttachmentByWorksId(element.getId());
//                element.setWorksAttachmentList(worksAttachments);
//            }
//            return list;
//    }


    @Autowired
    ProjectMapper projectMapper;
    @Override
    public List<Project> getProjectByCount(int page,int rows) {
        PageHelper.startPage(page,rows);
        List<Project> list = new ArrayList<>();
        ProjectExample example = new ProjectExample();
        example.setOrderByClause("`follower_count` desc");
        list = projectMapper.selectByExample(example);
        for (Project element:list){
            element.setSkillList(skillMapper.getProjectSkill(element.getId()));
        }
        return list;
    }

    @Override
    public List<Project> getProjectByTime(int page,int rows) {
        PageHelper.startPage(page,rows);
        List<Project> list = new ArrayList<>();
        ProjectExample example = new ProjectExample();
        example.setOrderByClause("gmt_create");
        list = projectMapper.selectByExample(example);
        for (Project element:list){
            element.setSkillList(skillMapper.getProjectSkill(element.getId()));
        }
        return list;
    }

    @Autowired
    SkillMapper skillMapper;
    @Override
    public List getSkillList() {
        return skillMapper.getAll();
    }


    @Autowired
    ProjectSkillMapper projectSkillMapper;
    @Override
    public List<Project> getProjectBySkill(int skill, int page, int rows) {
        PageHelper.startPage(page,rows);
        ProjectSkillExample example = new ProjectSkillExample();
        ProjectSkillExample.Criteria criteria = example.createCriteria();
        criteria.andSkillIdEqualTo(skill);
        List<ProjectSkill> list = projectSkillMapper.selectByExample(example);
        List<Project> projectList = new ArrayList<>();
        for(ProjectSkill projectSkill:list){

            Project project = projectMapper.selectByPrimaryKey(projectSkill.getProjectId());
            project.setSkillList(skillMapper.getProjectSkill(project.getId()));
            projectList.add(project);
        }
        return projectList;
    }

    @Autowired
    WorksMapper worksMapper;
    @Override
    public List<Works> getWorksByType(int page, int rows,String type) {
        PageHelper.startPage(page,rows);
        List<Works> list = new ArrayList<>();
        WorksExample example = new WorksExample();
        example.setOrderByClause(type);
        list = worksMapper.selectByExample(example);
        return list;
    }

    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Student> getStudentsList(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Student> list = new ArrayList<>();
        StudentExample example = new StudentExample();
        example.setOrderByClause("`follower_count` desc");
        list = studentMapper.selectByExample(example);
        for (Student student:list){
            student.setWorks(getWorksList(student.getId()));
            studentMapper.updateByPrimaryKey(student);
        }
        return list;
    }

    private List<Works> getWorksList(Long studentId) {
        WorksExample example = new WorksExample();
        WorksExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        List<Works> list = worksMapper.selectByExample(example);
        return list;
    }


    @Autowired
    WorksAttachmentMapper worksAttachmentMapper;
    private List<WorksAttachment> getAttachmentByWorksId(Long worksId){
        WorksAttachmentExample example = new WorksAttachmentExample();
        WorksAttachmentExample.Criteria criteria = example.createCriteria();
        criteria.andWorksIdEqualTo(worksId);
        List list= worksAttachmentMapper.selectByExample(example);
        return list;

    }






}
