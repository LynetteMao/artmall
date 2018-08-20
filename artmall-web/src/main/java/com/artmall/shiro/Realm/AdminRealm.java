package com.artmall.shiro.Realm;

import com.artmall.pojo.Admin;
import com.artmall.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author
 * @create 2018-08-20 8:44
 **/

public class AdminRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Autowired
    AdminService adminService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Admin admin = adminService.selectByUsername(token.getUsername());
        ByteSource salt = ByteSource.Util.bytes(admin.getSalt());
        if (admin != null) {
            return new SimpleAuthenticationInfo(admin.getLoginName(), admin.getHashedPwd(), salt, getName());
        }
        return null;

    }
}
