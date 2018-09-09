package com.artmall.pojo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class NewProjectExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public NewProjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_idIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_idEqualTo(Long value) {
            addCriterion("business_id =", value, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idNotEqualTo(Long value) {
            addCriterion("business_id <>", value, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idGreaterThan(Long value) {
            addCriterion("business_id >", value, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idGreaterThanOrEqualTo(Long value) {
            addCriterion("business_id >=", value, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idLessThan(Long value) {
            addCriterion("business_id <", value, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idLessThanOrEqualTo(Long value) {
            addCriterion("business_id <=", value, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idIn(List<Long> values) {
            addCriterion("business_id in", values, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idNotIn(List<Long> values) {
            addCriterion("business_id not in", values, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idBetween(Long value1, Long value2) {
            addCriterion("business_id between", value1, value2, "business_id");
            return (Criteria) this;
        }

        public Criteria andBusiness_idNotBetween(Long value1, Long value2) {
            addCriterion("business_id not between", value1, value2, "business_id");
            return (Criteria) this;
        }

        public Criteria andProject_nameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProject_nameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProject_nameEqualTo(String value) {
            addCriterion("project_name =", value, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameGreaterThan(String value) {
            addCriterion("project_name >", value, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameLessThan(String value) {
            addCriterion("project_name <", value, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameLike(String value) {
            addCriterion("project_name like", value, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameNotLike(String value) {
            addCriterion("project_name not like", value, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameIn(List<String> values) {
            addCriterion("project_name in", values, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_nameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "project_name");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionIsNull() {
            addCriterion("project_description is null");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionIsNotNull() {
            addCriterion("project_description is not null");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionEqualTo(String value) {
            addCriterion("project_description =", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionNotEqualTo(String value) {
            addCriterion("project_description <>", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionGreaterThan(String value) {
            addCriterion("project_description >", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionGreaterThanOrEqualTo(String value) {
            addCriterion("project_description >=", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionLessThan(String value) {
            addCriterion("project_description <", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionLessThanOrEqualTo(String value) {
            addCriterion("project_description <=", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionLike(String value) {
            addCriterion("project_description like", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionNotLike(String value) {
            addCriterion("project_description not like", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionIn(List<String> values) {
            addCriterion("project_description in", values, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionNotIn(List<String> values) {
            addCriterion("project_description not in", values, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionBetween(String value1, String value2) {
            addCriterion("project_description between", value1, value2, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionNotBetween(String value1, String value2) {
            addCriterion("project_description not between", value1, value2, "project_description");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedIsNull() {
            addCriterion("is_verified is null");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedIsNotNull() {
            addCriterion("is_verified is not null");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedEqualTo(Byte value) {
            addCriterion("is_verified =", value, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedNotEqualTo(Byte value) {
            addCriterion("is_verified <>", value, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedGreaterThan(Byte value) {
            addCriterion("is_verified >", value, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_verified >=", value, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedLessThan(Byte value) {
            addCriterion("is_verified <", value, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedLessThanOrEqualTo(Byte value) {
            addCriterion("is_verified <=", value, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedIn(List<Byte> values) {
            addCriterion("is_verified in", values, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedNotIn(List<Byte> values) {
            addCriterion("is_verified not in", values, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedBetween(Byte value1, Byte value2) {
            addCriterion("is_verified between", value1, value2, "is_verified");
            return (Criteria) this;
        }

        public Criteria andIs_verifiedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_verified not between", value1, value2, "is_verified");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNull() {
            addCriterion("budget is null");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNotNull() {
            addCriterion("budget is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetEqualTo(Long value) {
            addCriterion("budget =", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotEqualTo(Long value) {
            addCriterion("budget <>", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThan(Long value) {
            addCriterion("budget >", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThanOrEqualTo(Long value) {
            addCriterion("budget >=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThan(Long value) {
            addCriterion("budget <", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThanOrEqualTo(Long value) {
            addCriterion("budget <=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetIn(List<Long> values) {
            addCriterion("budget in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotIn(List<Long> values) {
            addCriterion("budget not in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetBetween(Long value1, Long value2) {
            addCriterion("budget between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotBetween(Long value1, Long value2) {
            addCriterion("budget not between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andTender_periodIsNull() {
            addCriterion("tender_period is null");
            return (Criteria) this;
        }

        public Criteria andTender_periodIsNotNull() {
            addCriterion("tender_period is not null");
            return (Criteria) this;
        }

        public Criteria andTender_periodEqualTo(Integer value) {
            addCriterion("tender_period =", value, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodNotEqualTo(Integer value) {
            addCriterion("tender_period <>", value, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodGreaterThan(Integer value) {
            addCriterion("tender_period >", value, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodGreaterThanOrEqualTo(Integer value) {
            addCriterion("tender_period >=", value, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodLessThan(Integer value) {
            addCriterion("tender_period <", value, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodLessThanOrEqualTo(Integer value) {
            addCriterion("tender_period <=", value, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodIn(List<Integer> values) {
            addCriterion("tender_period in", values, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodNotIn(List<Integer> values) {
            addCriterion("tender_period not in", values, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodBetween(Integer value1, Integer value2) {
            addCriterion("tender_period between", value1, value2, "tender_period");
            return (Criteria) this;
        }

        public Criteria andTender_periodNotBetween(Integer value1, Integer value2) {
            addCriterion("tender_period not between", value1, value2, "tender_period");
            return (Criteria) this;
        }

        public Criteria andExpected_timeIsNull() {
            addCriterion("expected_time is null");
            return (Criteria) this;
        }

        public Criteria andExpected_timeIsNotNull() {
            addCriterion("expected_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpected_timeEqualTo(Integer value) {
            addCriterion("expected_time =", value, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeNotEqualTo(Integer value) {
            addCriterion("expected_time <>", value, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeGreaterThan(Integer value) {
            addCriterion("expected_time >", value, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expected_time >=", value, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeLessThan(Integer value) {
            addCriterion("expected_time <", value, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeLessThanOrEqualTo(Integer value) {
            addCriterion("expected_time <=", value, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeIn(List<Integer> values) {
            addCriterion("expected_time in", values, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeNotIn(List<Integer> values) {
            addCriterion("expected_time not in", values, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeBetween(Integer value1, Integer value2) {
            addCriterion("expected_time between", value1, value2, "expected_time");
            return (Criteria) this;
        }

        public Criteria andExpected_timeNotBetween(Integer value1, Integer value2) {
            addCriterion("expected_time not between", value1, value2, "expected_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinish_timeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinish_timeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeLessThan(Date value) {
            addCriterion("finish_time <", value, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finish_time");
            return (Criteria) this;
        }

        public Criteria andFinish_timeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finish_time");
            return (Criteria) this;
        }

        public Criteria andGmt_createIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmt_createIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_createEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andSkillIsNull() {
            addCriterion("skill is null");
            return (Criteria) this;
        }

        public Criteria andSkillIsNotNull() {
            addCriterion("skill is not null");
            return (Criteria) this;
        }

        public Criteria andSkillEqualTo(String value) {
            addCriterion("skill =", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotEqualTo(String value) {
            addCriterion("skill <>", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThan(String value) {
            addCriterion("skill >", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThanOrEqualTo(String value) {
            addCriterion("skill >=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThan(String value) {
            addCriterion("skill <", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThanOrEqualTo(String value) {
            addCriterion("skill <=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLike(String value) {
            addCriterion("skill like", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotLike(String value) {
            addCriterion("skill not like", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillIn(List<String> values) {
            addCriterion("skill in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotIn(List<String> values) {
            addCriterion("skill not in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillBetween(String value1, String value2) {
            addCriterion("skill between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotBetween(String value1, String value2) {
            addCriterion("skill not between", value1, value2, "skill");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table project
     *
     * @mbg.generated do_not_delete_during_merge Sun Sep 09 16:22:42 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table project
     *
     * @mbg.generated Sun Sep 09 16:22:42 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}