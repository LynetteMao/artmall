package com.artmall.Dto;

/**
 * 注册界面
 *
 * @author mllove
 * @create 2018-09-18 21:30
 **/

public class RegisterDto {

    private String enterpriseName;
    private String name;
    private String idCard;
    private String password;
    private String varifyPassword;
    private String mail;
    private String phoneNumber;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVarifyPassword() {
        return varifyPassword;
    }

    public void setVarifyPassword(String varifyPassword) {
        this.varifyPassword = varifyPassword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
