package com.qfedu.entity;

import java.io.Serializable;

/**
 * (Township)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:08
 */
public class Township implements Serializable {
    private static final long serialVersionUID = 256762929515491659L;
    
    private Integer tid;
    
    private String tname;
    
    private Integer cid;


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

}