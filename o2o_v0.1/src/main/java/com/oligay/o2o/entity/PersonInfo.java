package com.oligay.o2o.entity;

import java.util.Date;

/**
 * @author guoyue
 * @date 2020-04-10
 */
public class PersonInfo {

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 头像图片地址
     */
    private String profileImg;

    /**
     * 性别
     */
    private String gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户状态
     */
    private Integer enableStatus;

    /**
     * 用户类型 1顾客 2店家 3管理员
     */
    private Integer userType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date lastEditTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "PersonInfo [userId=" + userId + ", name=" + name + ", profileImg=" + profileImg + ", gender=" + gender + ", email=" + email + ", enableStatus=" + enableStatus + ", userType="
                + userType + ", createTime=" + createTime + ", lastEditTime=" + lastEditTime + "]";
    }
}
