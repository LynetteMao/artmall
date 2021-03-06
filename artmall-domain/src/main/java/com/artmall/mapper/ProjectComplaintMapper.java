package com.artmall.mapper;

import com.artmall.pojo.ProjectComplaint;
import com.artmall.pojo.ProjectComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectComplaintMapper {
    long countByExample(ProjectComplaintExample example);

    int deleteByExample(ProjectComplaintExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectComplaint record);

    int insertSelective(ProjectComplaint record);

    List<ProjectComplaint> selectByExample(ProjectComplaintExample example);

    ProjectComplaint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectComplaint record, @Param("example") ProjectComplaintExample example);

    int updateByExample(@Param("record") ProjectComplaint record, @Param("example") ProjectComplaintExample example);

    int updateByPrimaryKeySelective(ProjectComplaint record);

    int updateByPrimaryKey(ProjectComplaint record);
}