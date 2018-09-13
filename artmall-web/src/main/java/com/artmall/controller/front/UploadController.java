package com.artmall.controller.front;

import com.artmall.pojo.Project;
import com.artmall.pojo.Works;
import com.artmall.response.ServerResponse;
import com.artmall.service.ProjectService;
import com.artmall.service.UploadService;
import com.artmall.service.WorksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传管理
 *
 * @author mllove
 * @create 2018-09-12 15:00
 **/
@RestController
@Api(description = "上传")

public class UploadController {


    @Autowired
    UploadService uploadService;
    @Autowired
    ProjectService projectService;

    /**
     * project表单上传
     * @param project
     * @return
     */
    @ApiOperation("发布项目表单上传")
    @RequestMapping(value = "/project/upload",method = RequestMethod.POST )
    public ServerResponse newProject (@RequestBody Project project){
        Project newProject = projectService.addProject(project);
        return ServerResponse.Success("上传成功",newProject);
    }

    /**
     * project附件上传
     * @param files
     * @param projectId
     * @return
     */
    @ApiOperation("发布项目文件上传")
    @RequestMapping(value = "/project/uploadAttachment",method = RequestMethod.POST )
    public ServerResponse projectAttachmentUpload (@RequestParam("files")MultipartFile []files,
                                                   @RequestParam("projectId") Long projectId){
        return uploadService.addProjectAttachmentInfo(files,projectId);

    }


    @Autowired
    WorksService worksService;
    @ApiOperation("学生作品上传")
    @RequestMapping(value = "/works/upload",method = RequestMethod.POST)
    public ServerResponse newWorks (@RequestBody Works works){
        Works newWorks = worksService.addWorks(works);
        return ServerResponse.Success("上传成功",newWorks);
    }

    /**
     * works附件上传
     * 上传后自动添加水印
     * 文件改名，并另存至另一个文件夹
     * @param files
     * @param worksId
     * @return
     */

    @RequestMapping(value = "/works/uploadAttachment",method = RequestMethod.POST )
    @ApiOperation("学生作品文件上传")
    public ServerResponse worksAttachmentUpload (@RequestParam("files")MultipartFile []files,
                                                   @RequestParam("worksId") Long worksId,
                                                 @RequestParam("showfile")MultipartFile showfile){
        uploadService.addWorksAttachmentInfo(files,worksId,showfile);
        return ServerResponse.Success("上传成功");
    }


    /**
     * 下载附件的时候，把一个project包含的所有附件都打包下载
     * @param projectId
     * @return
     */
    @ApiOperation("项目附件打包下载")
    @RequestMapping(value = "/projectAttachment/download",method = RequestMethod.GET )
    public ServerResponse projectAttachmentDownload (@RequestParam("projectId") Long projectId){
        return null;
    }

}
