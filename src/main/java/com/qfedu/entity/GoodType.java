package com.qfedu.entity;

import java.io.Serializable;

/**
 * (GoodType)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public class GoodType implements Serializable {
    private static final long serialVersionUID = 973182868308014237L;
    
    private Integer gtid;
    
    private String gtname;


    public Integer getGtid() {
        return gtid;
    }

    public void setGtid(Integer gtid) {
        this.gtid = gtid;
    }

    public String getGtname() {
        return gtname;
    }

    public void setGtname(String gtname) {
        this.gtname = gtname;
    }

}