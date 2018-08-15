package com.artmall.shiro.config;

/**
 * 配置shiro
 *
 * @author
 * @create 2018-08-08 10:18
 **/

import com.artmall.shiro.Realm.MyRealm;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;


/**
 * shiro核心通过Filter实现，通过URL规则进行过滤和权限校验
 * 配置shiro，相当于ssm结构中xml文件
 */
@Configuration
public class ShiroConfiguration {

//
//    @Value("${spring.redis.shiro.host}")
//    private String host;
//    @Value("${spring.redis.shiro.port}")
//    private int port;
//    @Value("${spring.redis.shiro.timeout}")
//    private int timeout;
//    @Value("${spring.redis.shiro.password}")
//    private String password;


    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

/*        //拦截器
        Map<String,String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("jwt", String.valueOf(new JWTFilter()));*/
        Map<String,String> filterChainDefinitionMap =  new LinkedHashMap<String,String>();
        //配置不会被拦截的链接 顺序判断
        //anon:所有url都可以匿名访问


        filterChainDefinitionMap.put("/static/**","anon");
        //配置退出,shiro已内置logout过滤器
        filterChainDefinitionMap.put("/logout","logout");
        //
        filterChainDefinitionMap.put("/register","anon");
//        filterChainDefinitionMap.put("/hello","anon");
        filterChainDefinitionMap.put("/info","anon");
        filterChainDefinitionMap.put("/login","anon");


        //表示需要认证，没有登陆是不能访问的
        filterChainDefinitionMap.put("/**","authc");
        //配置shiro默认登陆界面，不过在前后端分离中应该有前端路由控制
        shiroFilterFactoryBean.setLoginUrl("/unauth");
        /*shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setUnauthorizedUrl("/401");

        *//*
         * 定义url规则
         *
         *//*
        Map<String,String> filterRuleMap = new HashMap<>();
        filterRuleMap.put("/**","jwt");
        filterRuleMap.put("401","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterRuleMap);*/

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;

    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("MD5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1024);//散列的次数，比如散列两次，相当于 md5(md5(""));

        return hashedCredentialsMatcher;
    }
//    @Bean
//    public StudentRealm studentRealm(){
//        StudentRealm studentRealm = new StudentRealm();
//        return studentRealm;
//    }

   /* @Bean
    public BusinessRealm businessRealm(){
        BusinessRealm businessRealm = new BusinessRealm();
        return businessRealm;
    }*/
   @Bean
   public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
       return myRealm;
   }

    @Bean
    public SecurityManager securityManager(){
       System.out.println("securityManager.log");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setAuthenticator(modularRealmAuthenticator());
//        List<Realm> realms = new ArrayList<>();
//        //添加多个Realm
//        realms.add(studentRealm());
//        realms.add(businessRealm());
        securityManager.setRealm(myRealm());
//        securityManager.setRealm((Realm) realms);


        /*
        关闭shiro自带的session
         */
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }

    /**
     * Realm管理(使用自己重写的Realm策略，只要一个通过验证就通过验证)
     */
/*    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }*/


//    /**
//     * 下面的代码是添加注解支持
//     */
//    @Bean
//    @DependsOn("lifecycleBeanPostProcessor")
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
//        // https://zhuanlan.zhihu.com/p/29161098
//        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
//        return defaultAdvisorAutoProxyCreator;
//    }


//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager);
//        return advisor;
//    }

    //是否要设置解密规则
    /*@Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //采用MD5方式加密
        hashedCredentialsMatcher().setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
//        System.out.println("解密规则");
        return hashedCredentialsMatcher();
    }*/

//    //自定义sessionManager
//    @Bean
//    public SessionManager sessionManager() {
//        MySessionManager mySessionManager = new MySessionManager();
//        mySessionManager.setSessionDAO(redisSessionDAO());
//        return mySessionManager;
//    }
//
//    /**
//     * 配置shiro redisManager
//     * <p>
//     * 使用的是shiro-redis开源插件
//     *
//     * @return
//     */
//    public RedisManager redisManager() {
//        RedisManager redisManager = new RedisManager();
//        redisManager.setHost(host);
//        redisManager.setPort(port);
//        redisManager.setExpire(1800);// 配置缓存过期时间
//        redisManager.setTimeout(timeout);
//        redisManager.setPassword(password);
//        return redisManager;
//    }
//
//    /**
//     * cacheManager 缓存 redis实现
//     * <p>
//     * 使用的是shiro-redis开源插件
//     *
//     * @return
//     */
//    @Bean
//    public RedisCacheManager cacheManager() {
//        RedisCacheManager redisCacheManager = new RedisCacheManager();
//        redisCacheManager.setRedisManager(redisManager());
//        return redisCacheManager;
//    }
//
//    /**
//     * RedisSessionDAO shiro sessionDao层的实现 通过redis
//     * <p>
//     * 使用的是shiro-redis开源插件
//     */
//    @Bean
//    public RedisSessionDAO redisSessionDAO() {
//        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//        redisSessionDAO.setRedisManager(redisManager());
//        return redisSessionDAO;
//    }

}
