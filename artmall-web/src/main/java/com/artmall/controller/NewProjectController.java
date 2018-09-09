package com.artmall.controller;

import com.artmall.Impl.NewProjectServiceImpl;
import com.artmall.pojo.NewProject;
import com.artmall.response.ServerResponse;
import com.artmall.service.NewProjectService;
import com.artmall.utils.DateUtil;
import com.artmall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/NewProject")
public class NewProjectController {

    @Autowired
    private NewProjectService newProjectService;



    @RequestMapping("/upload")
    public ServerResponse<Integer> uploadProject(@RequestParam("business_id")Long businessId,
                                                 @RequestParam("project_name") String projectName,
                                                 @RequestParam("project_desciption")String projectDesciption,
                                                 @RequestParam("budget")Long budget,
                                                 @RequestParam("tender_period") Integer tenderPeriod,
                                                 @RequestParam("expected_time") Integer expectedTime,
                                                 @RequestParam("finish_time")String finishTime,
                                                 @RequestParam("files") MultipartFile []multipartFiles){

        NewProject newProject=new NewProject();
        newProject.setId(new IDUtils(5,6).nextId());
        newProject.setBusiness_id(businessId);
        newProject.setProject_name(projectName);
        newProject.setProject_description(projectDesciption);
        newProject.setIs_verified(Byte.valueOf("1"));
        newProject.setBudget(budget);
        newProject.setTender_period(tenderPeriod);
        newProject.setExpected_time(expectedTime);
        String []strTime=finishTime.split("-");
        int y=Integer.valueOf(strTime[0]);
        int m=Integer.valueOf(strTime[1]);
        int d= Integer.valueOf(strTime[2]);
        newProject.setFinish_time(new Date(y,m,d));
        newProject.setGmt_create(DateUtil.getDate());
        newProject.setGmt_modified(DateUtil.getDate());
        Boolean tF=newProjectService.uploadNewProject(newProject,multipartFiles);
        if(!tF)return ServerResponse.Failure("添加项目失败");
        return ServerResponse.Failure("添加项目成功");
    }
}
