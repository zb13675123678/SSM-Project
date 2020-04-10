package com.qfedu.entity;

import java.io.Serializable;

/**
 * (Province)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:08
 */
public class Province implements Serializable {
    private static final long serialVersionUID = -87973773256233805L;
    
    private Integer pid;
    
    private String pname;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

}