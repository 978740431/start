package com.star.model;

import java.util.Date;

/**
 * Created by zhangnan on 16/7/23.
 */
public class User {

    private int id;
    private String username;
    private String password;
    private Date createTime;
    private Date lostLoginTime;
    private String uuid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLostLoginTime() {
        return lostLoginTime;
    }

    public void setLostLoginTime(Date lostLoginTime) {
        this.lostLoginTime = lostLoginTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
