package com.artmall.pojo;

import java.util.Date;
import java.util.List;

public class Project {
    private Long id;

    private Long businessId;

    private String projectName;

    private String projectDescription;

    private Byte isVerified;

    private Long budget;

    private Integer tenderPeriod;

    private Integer expectedTime;

    private Date finishTime;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer followerCount;

    private List<Skill> skillList;

    private Integer bidCount;

    public Integer getBidCount() {
        return bidCount;
    }

    public void setBidCount(Integer bidCount) {
        this.bidCount = bidCount;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    private Double averagePrice;

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    public Byte getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Byte isVerified) {
        this.isVerified = isVerified;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Integer getTenderPeriod() {
        return tenderPeriod;
    }

    public void setTenderPeriod(Integer tenderPeriod) {
        this.tenderPeriod = tenderPeriod;
    }

    public Integer getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Integer expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }
}