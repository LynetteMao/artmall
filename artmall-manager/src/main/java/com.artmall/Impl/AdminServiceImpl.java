package com.artmall.Impl;

import com.artmall.mapper.AdminMapper;
import com.artmall.pojo.Admin;
import com.artmall.pojo.AdminExample;
import com.artmall.response.ServerResponse;
import com.artmall.service.AdminService;
import com.artmall.utils.IDUtils;
import com.artmall.utils.SaltUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author
 * @create 2018-08-20 8:53
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin selectByUsername(String username) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(username);
        List<Admin> list = adminMapper.selectByExample(example);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public ServerResponse<Admin> addUser(Admin admin) {
        Admin newAdmin = new Admin();
        newAdmin.setId(IDUtils.getIdUtils().nextId());
        newAdmin.setLoginName(admin.getLoginName());
        newAdmin.setSalt(SaltUtil.InitSalt());
        newAdmin.setHashedPwd(new SimpleHash("MD5",admin.getHashedPwd(),ByteSource.Util.bytes(newAdmin.getSalt()),1024).toString());
        newAdmin.setGmtCreate(new Date());
        try {
            adminMapper.insert(newAdmin);
        }catch (Exception e){
            return ServerResponse.Failure("注册失败");
        }
        return ServerResponse.Success("注册成功");
    }

    @Override
    public Admin selectByUserId(Long userid) {
        return adminMapper.selectByPrimaryKey(userid);
    }
}
