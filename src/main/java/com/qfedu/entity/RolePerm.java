package com.qfedu.entity;

import java.io.Serializable;

/**
 * (RolePerm)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:08
 */
public class RolePerm implements Serializable {
    private static final long serialVersionUID = -15170728334557960L;
    
    private Integer rid;
    
    private Integer pid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}