package com.artmall.controller.front;

import com.artmall.pojo.Project;
import com.artmall.pojo.Works;
import com.artmall.response.ServerResponse;
import com.artmall.service.BidService;
import com.artmall.service.ProjectService;
import com.artmall.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 投标管理
 *
 * @author mllove
 * @create 2018-09-16 10:04
 **/
@RestController
public class BidController {

    @Autowired
    ProjectService projectService;
    @RequestMapping(value = "/project/info/common",method = RequestMethod.GET)
    public ServerResponse getProjectInfo (@RequestParam("projectId")Long projectId){
        Project project = projectService.selectById(projectId);
        project = projectService.selectProjectInfo(project);
        if (project==null)
            return ServerResponse.Failure("nothing");
        else
            return ServerResponse.Success("project info show success",project);
    }



    /**
     *查看项目过期时间
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/project/info/time",method = RequestMethod.POST)
    public ServerResponse getProjectTime (@RequestParam("projectId") Long projectId){
        Project project = projectService.selectById(projectId);
        Date beginDate = project.getGmtCreate();
        Date endDate = DateUtil.getDeadline(beginDate,5);
        Long day = DateUtil.getRemainDay(new Date(),endDate);
        if (day<=0){
            projectService.deadProject(project);
            return ServerResponse.Failure("已到期");
        }
        return ServerResponse.Success("剩余时间",day);
    }


    /**
     * 给学生展示的project投标作评展示
     * @param projectId
     * @return
     */
    @Autowired
    BidService bidService;
    @RequestMapping(value = "/project/info/bidstudent",method = RequestMethod.POST )
    public ServerResponse getBidInfoToStudent ( @RequestParam("projectId") Long projectId){
        List<Works> worksList = bidService.getWorksList(projectId);
        for (Works works :worksList){

        }
        return null;
    }
}
