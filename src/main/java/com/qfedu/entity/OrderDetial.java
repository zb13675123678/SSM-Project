package com.qfedu.entity;

import java.io.Serializable;

/**
 * (OrderDetial)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public class OrderDetial implements Serializable {
    private static final long serialVersionUID = 443539354323481221L;
    
    private Integer did;
    
    private String oid;
    
    private String fdid;
    
    private Integer count;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFdid() {
        return fdid;
    }

    public void setFdid(String fdid) {
        this.fdid = fdid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}