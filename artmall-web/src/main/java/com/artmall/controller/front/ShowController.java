package com.artmall.controller.front;

import com.artmall.pojo.*;
import com.artmall.response.ServerResponse;
import com.artmall.service.ContentService;
import com.artmall.service.WorksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示管理
 *
 * @author
 * @create 2018-09-10 10:19
 **/
@RestController
@Api(description = "页面展示")
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ContentService contentService;


//    @RequestMapping(value = "/home")
//    @ApiOperation(value = "首页精品展示")
//    public ServerResponse<List<Works>> getHome (@RequestParam("page") int page,
//                                                @RequestParam("rows") int rows){
//
//        List<Works> list = contentService.getHome(page,rows);
//
//        return ServerResponse.Success("展示成功",list);
//    }

    @RequestMapping(value = "/project" ,method = RequestMethod.POST)
    @ApiOperation("浏览项目，method为排序根据，0为按照时间排序，1为按照follower的人数来排序")
    public ServerResponse<List<Project>> showProject (@RequestParam("method") int method,
                                                      @RequestParam("page") int page,
                                                      @RequestParam("rows") int rows){
        List<Project> list = new ArrayList<>();
        if (method == 0)
            list = contentService.getProjectByTime(page,rows);
        else if (method ==1)
            list =contentService.getProjectByCount(page,rows);
        return ServerResponse.Success("展示成功",list);
    }
    @ApiOperation("发现作品，method为排序根据，0为按照时间排序，1为按照follower的人数来排序")
    @RequestMapping(value = "/works" ,method = RequestMethod.POST)
    public ServerResponse<List<Works>> showWorks (@RequestParam("method") int method,
                                                      @RequestParam("page") int page,
                                                      @RequestParam("rows") int rows){
        List<Works> list = new ArrayList<>();
        if (method == 0)
            list = contentService.getWorksByType(page,rows,"gmt_create");
        else if (method ==1)
            list =contentService.getWorksByType(page,rows,"`follower_count` desc");
        return ServerResponse.Success("展示成功",list);
    }

    @Autowired
    WorksService worksService;
    @ApiOperation("查看某个作品的详情")
    @RequestMapping(value = "/works/attachment",method = RequestMethod.POST )
    public ServerResponse<List<WorksAttachment>> showWorksAttachment (@RequestParam("worksId")Long worksId){
        List<WorksAttachment> list = worksService.selectAttachmentByWorks(worksId);
        return ServerResponse.Success("展示成功",list);
    }

    @ApiOperation("人才排行榜")
    @RequestMapping(value = "/students",method = RequestMethod.POST )
    public ServerResponse<List<Student>> showStudents (int page, int rows){
        List<Student> list = contentService.getStudentsList(page,rows);
        return ServerResponse.Success("展示成功",list);

    }

    @ApiOperation("返回技能列表")
    @RequestMapping(value = "/skillList",method = RequestMethod.GET )
    public ServerResponse<List<Skill>> skillList(){
        List list = contentService.getSkillList();
        return ServerResponse.Success("List显示成功",list);
    }

    @ApiOperation("通过技能来筛选project")
    @RequestMapping(value = "/skillSelect",method = RequestMethod.POST )
    public ServerResponse<List<Project>> skillSelect (@RequestParam("skillId") int skillId,
                                                      @RequestParam("page") int page,
                                                      @RequestParam("rows") int rows){
        List<Project> list=contentService.getProjectBySkill(skillId,page,rows);
        return ServerResponse.Success("显示成功",list);
    }

}
