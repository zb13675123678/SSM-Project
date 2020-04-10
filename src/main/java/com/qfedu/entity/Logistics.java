package com.qfedu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Logistics)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public class Logistics implements Serializable {
    private static final long serialVersionUID = -92608569940413308L;
    
    private Integer lid;
    
    private String account;
    
    private String userId;
    
    private String oid;
    
    private Date payTime;
    
    private Date packageTime;
    
    private Date beginTime;
    
    private Date endTime;
    
    private Integer status;


    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPackageTime() {
        return packageTime;
    }

    public void setPackageTime(Date packageTime) {
        this.packageTime = packageTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}