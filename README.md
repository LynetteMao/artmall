# artmall  


author: mllove
# 所用到的框架
## 进度表   
 ### 基础框架  
 - [x] springboot多模块框架搭建(ssm)    
 - [x] spring boot整合mybatis,使用逆向生成工具
 - [x] 在云服务器上搭建好基础环境(mysql5.7+redis)
 ### 登录功能:   
 - [x] spring boot整合shiro,实现登录验证(多realm)   
 - [x] shiro整合JWT,实现单点登录
 - [x] 忘记密码，邮件发送验证码，重置密码
 ### API文档   
 - [x] 整合swagger,生成API文档   
  
---   
# 具体进度
 ### 企业管理   

 * 注册功能   
    - [x] 将数据写入数据库，自动生成businnesId
    - [x] 将token和business存入redis(整合redis,且javabean以json形式存放)
    - [x] 发送验证邮件   
    - [x] 发送的邮件乱码问题
    - [x] 实现邮件的验证,邮箱验证后才将数据存入数据库   
    - [x] 单文件的上传 
    - [ ] 管理员审核，修改状态       

* 登录  
    - [x] 企业登录   
* 信息修改   
    - [x] 修改密码   
    - [ ] 修改企业信息   
  
   

 ### 学生管理   
 * 登录管理        
    - [x] 学生第一次登录修改密码   
    - [x] 学生登录   
 * 信息修改   
    - [X] 修改密码   
    - [ ] 修改个人信息   
  - [ ] 上传作品   
  - [ ] 个人主页   
     
 ### 主页管理   
 ~~精品展示~~ 
 - [ ] 发现作品(分页、排序)
 - [x] 浏览项目(分页、排序、技能)

#### 人才排行榜   
 - [ ] student加`list<works>`   
 - [ ] 按照followers排序   
 - [ ] 分页 
 