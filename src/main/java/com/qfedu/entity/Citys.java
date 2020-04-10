package com.qfedu.entity;

import java.io.Serializable;

/**
 * (Citys)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public class Citys implements Serializable {
    private static final long serialVersionUID = 634965335415088356L;
    
    private Integer cid;
    
    private String cname;
    
    private Integer pid;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}