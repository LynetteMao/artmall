package com.artmall.Impl;

import com.artmall.mapper.BusinessAttachmentMapper;
import com.artmall.mapper.BusinessMapper;
import com.artmall.pojo.Business;

import com.artmall.pojo.BusinessAttachment;
import com.artmall.pojo.BusinessExample;
import com.artmall.response.ServerResponse;
import com.artmall.service.BusinessService;
import com.artmall.service.StorageService;
import com.artmall.storage.FileSystemStorageService;
import com.artmall.utils.IDUtils;
import com.artmall.utils.SaltUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @create 2018-08-08 14:10
 **/
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper businessMapper;

    @Override
    public Business selectBusinessByEmail(String email) {
        BusinessExample example = new BusinessExample();
        BusinessExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<Business> list = businessMapper.selectByExample(example);
        return list.get(0);


    }

    @Override
    public Business selectBusinessById(Long userNo) {
        return null;
    }


    @Override
    public ServerResponse<Business> addUser(Business business) {
        System.out.println("hashpass为"+business.getHashedPwd());
        Business newBusiness = new Business();
        //校验

        newBusiness.setId(new IDUtils(3, 4).nextId());
        newBusiness.setBusinessName(business.getBusinessName());
        newBusiness.setRepresentationName(business.getRepresentationName());
        newBusiness.setRepresentationIdcard(business.getRepresentationIdcard());
        //要验证
        newBusiness.setEmail(business.getEmail());
        newBusiness.setTel(business.getTel());

        newBusiness.setSalt(SaltUtil.InitSalt());
        newBusiness.setHashedPwd(new SimpleHash("MD5", business.getHashedPwd(), ByteSource.Util.bytes(newBusiness.getSalt()), 1024).toString());

        newBusiness.setGmtCreate(new Date());
        newBusiness.setGmtModified(new Date());
        //0为邮箱未验证，且未通过管理员审核
        newBusiness.setIsVerified((byte) 0);

        try {
            businessMapper.insert(newBusiness);
        } catch (Exception e) {
            return ServerResponse.Failure("插入失败");
        }

        return ServerResponse.Success("插入成功",newBusiness);
    }


}
