package com.artmall.service;

import com.artmall.pojo.Project;
import com.artmall.pojo.Student;
import com.artmall.pojo.Works;
import com.artmall.response.ServerResponse;

import java.util.List;

/**
 * 面板控制
 *
 * @author
 * @create 2018-09-10 10:36
 **/

public interface ContentService {


    /**
     * 获取首页数据
     * @return
     */
//    List<Works> getHome(int page,int rows);

    /**
     * 分页按照关注度排序
     * @return
     */
    List<Project> getProjectByCount(int page, int rows);

    /**
     * 分页按照发布时间排序
     * @return
     */
    List<Project> getProjectByTime(int page,int rows);

    /**
     * 获取所有skill的列表
     * @return
     */
    List getSkillList();

    /**
     * 通过skill来搜索project
     * @param page
     * @param rows
     * @return
     */
    List<Project> getProjectBySkill(int skill,int page, int rows);


    List<Works> getWorksByType(int page, int rows,String type);

    List<Student> getStudentsList(int page, int rows);
}
