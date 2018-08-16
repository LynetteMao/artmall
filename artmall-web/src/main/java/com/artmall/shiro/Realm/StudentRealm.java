package com.artmall.shiro.Realm;

import com.artmall.pojo.Student;
import com.artmall.service.StudentService;
import com.artmall.service.UserService;
import com.artmall.shiro.JWT.JWTToken;
import com.artmall.utils.JWTUtil;
import com.auth0.jwt.JWT;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author
 * @create 2018-08-14 16:57
 **/

public class StudentRealm extends AuthorizingRealm {
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JWTToken;
//    }

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

/*        //获取用户id
        Long id = JWTUtil.getUserNo(principals.toString());
        System.out.println(id);
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //获得授权角色
        authorizationInfo.setRoles( userService.getRoles(id));
        //获得授权权限
        authorizationInfo.setStringPermissions(userService.getPermissions(id));
        return authorizationInfo;*/
        return null;
    }


    @Autowired
    StudentService studentService;

    @Override
    //authenticationToken存放的是用户输入信息(通常为用户名和密码)，要拿这个信息和
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println(token.getPassword());

        Student student = studentService.selectStudentByStuId(token.getUsername());
        System.out.println(student.toString());
        ByteSource salt = ByteSource.Util.bytes(student.getSalt());
        if (student != null) {
            System.out.println("开始验证");
            System.out.println("studentid:" + student.getStudentId() + "stdentsalt:" + salt + "password" + student.getHashedPwd());
            return new SimpleAuthenticationInfo(student.getStudentId(), student.getHashedPwd(), salt, getName());
        }
        return null;

    }
}
