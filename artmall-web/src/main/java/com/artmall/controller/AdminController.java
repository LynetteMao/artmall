package com.artmall.controller;

import com.artmall.pojo.Admin;
import com.artmall.response.Const;
import com.artmall.response.ServerResponse;
import com.artmall.service.AdminService;
import com.artmall.utils.JWTUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mllove
 * @create 2018-08-20 10:09
 **/
@RestController

@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    //管理员登入后
    @ApiOperation(value = "添加管理员")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ServerResponse addAdmin(@RequestParam(name = "username") String username,
                                          @RequestParam(name = "password") String password){

        Admin admin = new Admin();
        admin.setLoginName(username);
        admin.setHashedPwd(password);
        return adminService.addUser(admin);
    }

    @ApiOperation(value = "管理员登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST )
    public ServerResponse AdminLogin(@RequestParam(name = "username")String username,
                                            @RequestParam(name = "password") String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Admin admin = adminService.selectByUsername(username);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (UnknownAccountException uae){
            return ServerResponse.Failure("用户不存在");
        }catch (IncorrectCredentialsException ice) {
            return ServerResponse.Failure("信息不匹配");
        }catch (AuthenticationException ae){
            return ServerResponse.Failure("error");
        }
        return ServerResponse.Success(JWTUtil.sign(admin.getId(),Const.LoginType.ADMIN));
    }


}
