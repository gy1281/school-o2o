package com.oligay.o2o.entity;

import java.util.Date;

/**
 * @author guoyue
 * @date 2020-04-10
 */
public class Area {

    /**
     * 区域Id
     */
    private Integer areaId;


    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 区域描述
     */
    private String areaDesc;


    /**
     * 权重,数值越大页面展示越靠前
     */
    private Integer priority;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date lastEditTime;


    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public String getAreaDesc() {
        return areaDesc;
    }

    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc;
    }

    @Override
    public String toString() {
        return "Area [areaId=" + areaId + ", areaName=" + areaName + ", areaDesc=" + areaDesc + ", priority=" + priority + ", createTime=" + createTime + ", lastEditTime=" + lastEditTime + "]";
    }

}

