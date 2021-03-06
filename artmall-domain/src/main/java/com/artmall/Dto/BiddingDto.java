package com.artmall.Dto;

import com.artmall.pojo.Skill;

import java.util.List;

/**
 * 投标作品展示(student可见)
 *
 * @author mllove
 * @create 2018-09-17 16:52
 **/

public class BiddingDto {
    private Long studentId;
    private String loginName;
    private List<Skill> skill;
    private Integer count;
    private Integer breakTime;
    private Long price;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Integer breakTime) {
        this.breakTime = breakTime;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
