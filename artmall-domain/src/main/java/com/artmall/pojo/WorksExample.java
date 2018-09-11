package com.artmall.pojo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class WorksExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public WorksExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
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
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
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

        public Criteria andStudent_idIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudent_idIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudent_idEqualTo(Long value) {
            addCriterion("student_id =", value, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idNotEqualTo(Long value) {
            addCriterion("student_id <>", value, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idGreaterThan(Long value) {
            addCriterion("student_id >", value, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idGreaterThanOrEqualTo(Long value) {
            addCriterion("student_id >=", value, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idLessThan(Long value) {
            addCriterion("student_id <", value, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idLessThanOrEqualTo(Long value) {
            addCriterion("student_id <=", value, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idIn(List<Long> values) {
            addCriterion("student_id in", values, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idNotIn(List<Long> values) {
            addCriterion("student_id not in", values, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idBetween(Long value1, Long value2) {
            addCriterion("student_id between", value1, value2, "student_id");
            return (Criteria) this;
        }

        public Criteria andStudent_idNotBetween(Long value1, Long value2) {
            addCriterion("student_id not between", value1, value2, "student_id");
            return (Criteria) this;
        }

        public Criteria andWorks_nameIsNull() {
            addCriterion("works_name is null");
            return (Criteria) this;
        }

        public Criteria andWorks_nameIsNotNull() {
            addCriterion("works_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorks_nameEqualTo(String value) {
            addCriterion("works_name =", value, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameNotEqualTo(String value) {
            addCriterion("works_name <>", value, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameGreaterThan(String value) {
            addCriterion("works_name >", value, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameGreaterThanOrEqualTo(String value) {
            addCriterion("works_name >=", value, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameLessThan(String value) {
            addCriterion("works_name <", value, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameLessThanOrEqualTo(String value) {
            addCriterion("works_name <=", value, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameLike(String value) {
            addCriterion("works_name like", value, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameNotLike(String value) {
            addCriterion("works_name not like", value, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameIn(List<String> values) {
            addCriterion("works_name in", values, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameNotIn(List<String> values) {
            addCriterion("works_name not in", values, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameBetween(String value1, String value2) {
            addCriterion("works_name between", value1, value2, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_nameNotBetween(String value1, String value2) {
            addCriterion("works_name not between", value1, value2, "works_name");
            return (Criteria) this;
        }

        public Criteria andWorks_describeIsNull() {
            addCriterion("works_describe is null");
            return (Criteria) this;
        }

        public Criteria andWorks_describeIsNotNull() {
            addCriterion("works_describe is not null");
            return (Criteria) this;
        }

        public Criteria andWorks_describeEqualTo(String value) {
            addCriterion("works_describe =", value, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeNotEqualTo(String value) {
            addCriterion("works_describe <>", value, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeGreaterThan(String value) {
            addCriterion("works_describe >", value, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeGreaterThanOrEqualTo(String value) {
            addCriterion("works_describe >=", value, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeLessThan(String value) {
            addCriterion("works_describe <", value, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeLessThanOrEqualTo(String value) {
            addCriterion("works_describe <=", value, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeLike(String value) {
            addCriterion("works_describe like", value, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeNotLike(String value) {
            addCriterion("works_describe not like", value, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeIn(List<String> values) {
            addCriterion("works_describe in", values, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeNotIn(List<String> values) {
            addCriterion("works_describe not in", values, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeBetween(String value1, String value2) {
            addCriterion("works_describe between", value1, value2, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_describeNotBetween(String value1, String value2) {
            addCriterion("works_describe not between", value1, value2, "works_describe");
            return (Criteria) this;
        }

        public Criteria andWorks_statusIsNull() {
            addCriterion("works_status is null");
            return (Criteria) this;
        }

        public Criteria andWorks_statusIsNotNull() {
            addCriterion("works_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorks_statusEqualTo(Byte value) {
            addCriterion("works_status =", value, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusNotEqualTo(Byte value) {
            addCriterion("works_status <>", value, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusGreaterThan(Byte value) {
            addCriterion("works_status >", value, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusGreaterThanOrEqualTo(Byte value) {
            addCriterion("works_status >=", value, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusLessThan(Byte value) {
            addCriterion("works_status <", value, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusLessThanOrEqualTo(Byte value) {
            addCriterion("works_status <=", value, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusIn(List<Byte> values) {
            addCriterion("works_status in", values, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusNotIn(List<Byte> values) {
            addCriterion("works_status not in", values, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusBetween(Byte value1, Byte value2) {
            addCriterion("works_status between", value1, value2, "works_status");
            return (Criteria) this;
        }

        public Criteria andWorks_statusNotBetween(Byte value1, Byte value2) {
            addCriterion("works_status not between", value1, value2, "works_status");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andFollower_countIsNull() {
            addCriterion("follower_count is null");
            return (Criteria) this;
        }

        public Criteria andFollower_countIsNotNull() {
            addCriterion("follower_count is not null");
            return (Criteria) this;
        }

        public Criteria andFollower_countEqualTo(Integer value) {
            addCriterion("follower_count =", value, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countNotEqualTo(Integer value) {
            addCriterion("follower_count <>", value, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countGreaterThan(Integer value) {
            addCriterion("follower_count >", value, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("follower_count >=", value, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countLessThan(Integer value) {
            addCriterion("follower_count <", value, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countLessThanOrEqualTo(Integer value) {
            addCriterion("follower_count <=", value, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countIn(List<Integer> values) {
            addCriterion("follower_count in", values, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countNotIn(List<Integer> values) {
            addCriterion("follower_count not in", values, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countBetween(Integer value1, Integer value2) {
            addCriterion("follower_count between", value1, value2, "follower_count");
            return (Criteria) this;
        }

        public Criteria andFollower_countNotBetween(Integer value1, Integer value2) {
            addCriterion("follower_count not between", value1, value2, "follower_count");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table works
     *
     * @mbg.generated do_not_delete_during_merge Mon Sep 10 16:53:51 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table works
     *
     * @mbg.generated Mon Sep 10 16:53:51 CST 2018
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