package com.artmall.shiro.Realm;

import com.artmall.pojo.Student;
import com.artmall.pojo.User;
import com.artmall.pojo.UserMember;
import com.artmall.response.Const;
import com.artmall.service.BusinessService;
import com.artmall.service.StudentService;
import com.artmall.service.UserService;
import com.artmall.shiro.JWT.JWTToken;
import com.artmall.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author
 * @create 2018-08-16 14:03
 **/

public class JWTRealm extends AuthorizingRealm {
    @Autowired
    StudentService studentService;
    @Autowired
    BusinessService businessService;

    @Override
    public boolean supports(AuthenticationToken token) {

        return token instanceof JWTToken;
    }
//    public Class<?> getAuthenticationTokenClass(){
//        return JWTToken.class;
//    }
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String token = (String) principalCollection.getPrimaryPrincipal();
        Long userId = JWTUtil.getUserNo(token);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userService.getRoles(userId));
        simpleAuthorizationInfo.setStringPermissions(userService.getPermissions(userId));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (!(authenticationToken instanceof JWTToken)){ return null; }
        JWTToken jwtToken =(JWTToken) authenticationToken;
        String jwt = (String) jwtToken.getCredentials();
        System.out.println("jwt为"+jwt);
//        UserMember user = null;
//        String type;
            Long userid = JWTUtil.getUserNo(jwt);
            System.out.println("userid是"+userid);
            Student student = studentService.selectStudentById(userid);
//            if (JWTUtil.getUserType(jwt).equals(Const.LoginType.STUDENT)){
//                user=studentService.selectStudentById(userid);
//            }
//            if (JWTUtil.getUserType(jwt).equals(Const.LoginType.BUSINESS)){
//                user=businessService.selectBusinessById(userid);
//            }


            if (student == null)
                throw new AuthenticationException("User didn't exit it");
            if (!JWTUtil.verify(jwt,userid))
                throw new AuthenticationException("username or password error");
            return new SimpleAuthenticationInfo(jwt,jwt,getName());

    }
}
