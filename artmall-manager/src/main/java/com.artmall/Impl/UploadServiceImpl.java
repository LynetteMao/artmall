package com.artmall.Impl;

import com.artmall.mapper.BusinessAttachmentMapper;
import com.artmall.mapper.ProjectAttachmentMapper;
import com.artmall.mapper.WorksAttachmentMapper;
import com.artmall.mapper.WorksMapper;
import com.artmall.pojo.*;
import com.artmall.response.ServerResponse;
import com.artmall.service.StorageService;
import com.artmall.service.UploadService;
import com.artmall.utils.IDUtils;
import com.artmall.utils.ImageUtils;
import com.sun.imageio.plugins.common.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Date;

/**
 * 文件的上传和下载
 *
 * @author mllove
 * @create 2018-09-11 19:37
 **/
@Service
public class UploadServiceImpl implements UploadService {


    @Autowired
    StorageService storageService;

    /**
     * 将企业注册时上传的工商证明图片存入服务器，并将信息打包成javabean封装
     * @param file
     * @param id
     * @return
     */
    @Override
    public BusinessAttachment addBusinessAttachmentInfoToRedis(MultipartFile []file, Long id) {
        BusinessAttachment businessAttachment =new BusinessAttachment();
        Path [] paths =storageService.fileUpload("business",file);
        businessAttachment.setId(new IDUtils(5, 6).nextId());
        businessAttachment.setAttachmentName(paths[0].getFileName().toString());
        businessAttachment.setAttachmentPath(paths[0].toString());
        businessAttachment.setAttachmentSize(file[0].getSize());
        businessAttachment.setAttachmentType("0");
        businessAttachment.setBusinessId(id);
        businessAttachment.setGmtCreate(new Date());
        businessAttachment.setGmtModified(new Date());

        return businessAttachment;
    }

    /**
     * 将数据录入数据库
     */
    @Autowired
    BusinessAttachmentMapper businessAttachmentMapper;
    @Override
    public ServerResponse addBusinessAttachmentInfo(BusinessAttachment businessAttachment) {
        try {
            businessAttachmentMapper.insert(businessAttachment);
            return ServerResponse.Success("数据插入成功");
        }catch (Exception e){
            return ServerResponse.Failure("failed");
        }
    }

    @Autowired
    ProjectAttachmentMapper projectAttachmentMapper;
    @Override
    public ServerResponse addProjectAttachmentInfo(MultipartFile[] files,Long id) {

        int len = files.length;
        Path [] paths= storageService.fileUpload("project\\"+id.toString()+"\\",files);
        for (int i=0;i<len;i++){
            if (!insertProjectAttachment(paths[i],files[i],id)) {
                delectProjectAttachment(id);
                return ServerResponse.Failure("error，请重新上传附件");
            }
        }
        return ServerResponse.Success("sucess");
    }

    @Override
    public ServerResponse addWorksAttachmentInfo(MultipartFile[] files, Long worksId,MultipartFile showfile) {
        String pathSign="works\\"+worksId.toString()+"\\";
        int len = files.length;
        Path [] paths= storageService.fileUpload(pathSign,files);
        //上传封面图片
        addWorksShowFile(showfile,worksId,pathSign);
        String watermartPath = null;
        for (int i=0;i<len;i++){

            watermartPath =storageService.makeWatermarkPath(pathSign,paths[i].getFileName().toString()).toString();
            ImageUtils.generateWatermark(paths[i].toString(),watermartPath);

            if (!insertWorksAttachment(paths[i],files[i],worksId,watermartPath)) {
                delectWorksAttachment(worksId);
                return ServerResponse.Failure("error，请重新上传附件");
            }

        }
        return ServerResponse.Success("sucess");
    }

    @Autowired
    WorksMapper worksMapper;
    private void addWorksShowFile(MultipartFile showfile, Long worksId,String pathSign) {
        Path showfilePath=storageService.makeImageDirectoryPath(pathSign,showfile.getOriginalFilename());
        storageService.store(showfile,showfilePath);
        ImageUtils.generateDirectoryThumbnail(showfilePath);
        Works works= worksMapper.selectByPrimaryKey(worksId);
        works.setAttachmentShowName(showfile.getOriginalFilename());
        works.setAttachmentShowPath(showfilePath.toString());
        worksMapper.updateByPrimaryKey(works);
    }


    @Autowired
    WorksAttachmentMapper worksAttachmentMapper;
    private void delectWorksAttachment(Long worksId) {
        WorksAttachmentExample ex = new WorksAttachmentExample();
        WorksAttachmentExample.Criteria criteria = ex.createCriteria();
        criteria.andWorksIdEqualTo(worksId);
        worksAttachmentMapper.deleteByExample(ex);
    }


    private boolean insertWorksAttachment(Path path, MultipartFile file, Long worksId,String watermarkPath) {

        WorksAttachment worksAttachment = new WorksAttachment();
        worksAttachment.setAttachmentName(file.getOriginalFilename());
        worksAttachment.setAttachmentPath(path.toString());
        worksAttachment.setAttachmentSize(file.getSize());
        worksAttachment.setWorksId(worksId);
        worksAttachment.setGmtCreate(new Date());
        worksAttachment.setGmtModified(new Date());
        worksAttachment.setAttachmentWatermarkPath(watermarkPath);
        try {
            worksAttachmentMapper.insert(worksAttachment);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 删除此project下的所有附件
     * @param id
     */
    private void delectProjectAttachment(Long id) {
        ProjectAttachmentExample ex = new ProjectAttachmentExample();
        ProjectAttachmentExample.Criteria criteria = ex.createCriteria();
        criteria.andProjectIdEqualTo(id);
        projectAttachmentMapper.deleteByExample(ex);
    }

    private boolean insertProjectAttachment(Path path,MultipartFile file, Long id) {
        ProjectAttachment projectAttachment = new ProjectAttachment();

        projectAttachment.setAttachmentName(file.getOriginalFilename());
        projectAttachment.setAttachmentPath(path.toString());
        projectAttachment.setAttachmentSize(file.getSize());
        projectAttachment.setProjectId(id);
        projectAttachment.setGmtModified(new Date());
        projectAttachment.setGmtCreate(new Date());
        try {
            projectAttachmentMapper.insert(projectAttachment);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
