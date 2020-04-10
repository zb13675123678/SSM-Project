package com.qfedu.entity;

import java.io.Serializable;

/**
 * (EmpRole)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public class EmpRole implements Serializable {
    private static final long serialVersionUID = -15882611305990662L;
    
    private Integer eid;
    
    private Integer rid;


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}