package com.star.model;

import java.util.Date;

/**
 * Created by zhangnan on 16/11/24.
 */
public class SendSMS {


    private int id;
    private String sendCode;
    private String mobile;
    private String smsTemp;
    private int isUsed;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsTemp() {
        return smsTemp;
    }

    public void setSmsTemp(String smsTemp) {
        this.smsTemp = smsTemp;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
