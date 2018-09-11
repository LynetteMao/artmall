package com.artmall.Impl;

import com.artmall.mapper.WorksAttachmentMapper;
import com.artmall.mapper.WorksMapper;
import com.artmall.pojo.NewProjectAttachmentExample;
import com.artmall.pojo.Works;
import com.artmall.pojo.WorksAttachment;
import com.artmall.pojo.WorksAttachmentExample;
import com.artmall.service.WorksService;
import com.artmall.utils.DateUtil;
import com.artmall.utils.FileUtils;
import com.artmall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorksServicesImpl implements WorksService {


    private List<Works> worksList;
    private List<List<WorksAttachment>> attachmentList;

    @Autowired
    private WorksMapper worksMapper;
    @Autowired
    private WorksAttachmentMapper worksAttachmentMapper;

    @Override
    public Boolean uploadWorks(Works work, MultipartFile[] multipartFiles) {
        String[] allPath = FileUtils.upFile("WorksFiles",multipartFiles);
        if (allPath == null) {
            return false;
        }
        int res=worksMapper.insert(work);
        Boolean tF=uploadWorksAttachment(allPath,multipartFiles,work.getId());
        if (res <= 0 || !tF){
            FileUtils.deleteFiles(allPath);
            if(res<=0)worksMapper.deleteByPrimaryKey(work.getId());
            return false;
        }
        return true;
    }
    private Boolean uploadWorksAttachment(String[] allPath, MultipartFile[] multipartFiles, Long worksId){
        int len=multipartFiles.length;
        WorksAttachment []worksAttachments=new WorksAttachment[len];
        Long []ID=new Long[len];
        for(int i=0;i<len;i++){
            ID[i]=IDUtils.getIdUtils().nextId();
        }
        for(int i=0;i<len;i++){
            MultipartFile mu=multipartFiles[i];
            worksAttachments[i]=new WorksAttachment();
            WorksAttachment wA=worksAttachments[i];
            wA.setId(ID[i]);
            wA.setAttachment_name(mu.getOriginalFilename());
            wA.setAttachment_path(allPath[i]);
            wA.setAttachment_size(mu.getSize());
            wA.setWorks_id(worksId);
            wA.setGmt_create(DateUtil.getDate());
            wA.setGmt_modified(DateUtil.getDate());
            int res=worksAttachmentMapper.insert(wA);
            if (res <= 0) {
                for (int j = i - 1; j >= 0; j--) {
                    worksAttachmentMapper.deleteByPrimaryKey(ID[i]);
                }
                return false;
            }
        }
        return true;
    }
}
