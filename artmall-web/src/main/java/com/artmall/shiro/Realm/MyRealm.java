package com.artmall.shiro.Realm;

import com.artmall.pojo.Student;
import com.artmall.service.StudentService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author
 * @create 2018-08-14 16:57
 **/

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Autowired
    StudentService studentService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        System.out.println(token.getPassword());

        Student student = studentService.selectStudentByStuId(token.getUsername());
        System.out.println(student.toString());
        ByteSource salt = ByteSource.Util.bytes(student.getSalt());
        if (student!=null){
            System.out.println("开始验证");
            System.out.println("studentid:"+student.getStudentId()+"stdentsalt:"+salt+"password"+student.getHashedPwd());
            return new SimpleAuthenticationInfo(student.getStudentId(),student.getHashedPwd(),salt,getName());
        }
        return null;
    }


//    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
//        hashedCredentialsMatcher.setHashIterations(2);
//        super.setCredentialsMatcher(hashedCredentialsMatcher);
//    }

}
