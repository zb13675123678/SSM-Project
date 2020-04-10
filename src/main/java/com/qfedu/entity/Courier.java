package com.qfedu.entity;

import java.io.Serializable;

/**
 * (Courier)实体类
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public class Courier implements Serializable {
    private static final long serialVersionUID = 618919492971133440L;
    
    private String account;
    
    private String name;
    
    private String tel;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}