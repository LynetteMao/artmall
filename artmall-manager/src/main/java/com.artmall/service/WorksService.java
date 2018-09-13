package com.artmall.service;

import com.artmall.pojo.Works;
import com.artmall.pojo.WorksAttachment;

import java.util.List;

public interface WorksService {

    Works addWorks(Works works);

    List<WorksAttachment> selectAttachmentByWorks(Long worksId);
}
