package com.artmall.Impl;

import com.artmall.mapper.WorksAttachmentMapper;
import com.artmall.mapper.WorksMapper;
import com.artmall.pojo.Student;
import com.artmall.pojo.Works;
import com.artmall.pojo.WorksAttachment;
import com.artmall.pojo.WorksAttachmentExample;
import com.artmall.service.StudentService;
import com.artmall.service.WorksService;
import com.artmall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author mllove
 * @create 2018-09-12 18:00
 **/
@Service
public class WorksServiceImpl implements WorksService {

    @Autowired
    StudentService studentService;
    @Autowired
    WorksMapper worksMapper;
    @Override
    public Works addWorks(Works works) {
        Works newWorks = new Works();
        Student student = studentService.getStudent();
        if (student==null)
            return null;
        newWorks.setId(new IDUtils(1,5).nextId());
        newWorks.setStudentId(student.getId());
        newWorks.setWorksName(works.getWorksName());
        newWorks.setWorksDescribe(works.getWorksDescribe());
        newWorks.setWorksStatus(Byte.valueOf("0"));
        newWorks.setPrice(works.getPrice());
        newWorks.setGmtCreate(new Date());
        newWorks.setGmtModified(new Date());
        newWorks.setFollowerCount(0);
        try {
            worksMapper.insert(newWorks);
            return newWorks;
        }catch (Exception e) {
            return null;
        }
    }

    @Autowired
    WorksAttachmentMapper worksAttachmentMapper;
    @Override
    public List<WorksAttachment> selectAttachmentByWorks(Long worksId) {
        WorksAttachmentExample example = new WorksAttachmentExample();
        WorksAttachmentExample.Criteria criteria = example.createCriteria();
        criteria.andWorksIdEqualTo(worksId);
        List<WorksAttachment> list = worksAttachmentMapper.selectByExample(example);
        return  list;
    }
}
