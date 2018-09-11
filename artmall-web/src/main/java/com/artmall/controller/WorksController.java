package com.artmall.controller;

/***************************冲突部分
import com.artmall.Impl.WorksServicesImpl;
import com.artmall.mapper.WorksMapper;
import com.artmall.pojo.Works;
import com.artmall.response.ServerResponse;
import com.artmall.service.WorksService;
import com.artmall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@RestController
@RequestMapping("/works")
public class WorksController {

    @Autowired
    private WorksServicesImpl worksServices;
    @RequestMapping("/upload")
    public ServerResponse<Integer> uploadWorks(@RequestParam("student_id") Long studentId,
                                               @RequestParam("works_name") String worksName,
                                               @RequestParam("works_describe") String worksDescribe,
                                               @RequestParam("price") Long price,
                                               @RequestParam("files") MultipartFile []multipartFiles){

        Works works=new Works();
        works.setId(IDUtils.getIdUtils().nextId());
        works.setStudent_id(studentId);
        works.setWorks_status(Byte.valueOf("1"));
        works.setWorks_describe(worksDescribe);
        works.setPrice(price);
        works.setWorks_name(worksName);
        worksServices.uploadWorks(works,multipartFiles);
        return ServerResponse.Success("作品1上传成功");
    }


=======
import org.springframework.web.bind.annotation.RestController;

/**
 * 作品管理
 *
 * @author
 * @create 2018-09-07 13:37
 **/

@RestController
public class WorksController {
******************************************/
}
