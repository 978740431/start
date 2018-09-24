package com.star.model.btc;

import java.util.Date;

/**
 * @Author 张楠
 * @Date 2018-07-2018/7/23 下午9:46
 * @Describe
 * @Version
 * @since
 */
public class CoinCountTime {


    private Long coinCount;
    private Date createTime;
    private String coinType;
    private Integer dataType;


    public Long getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Long coinCount) {
        this.coinCount = coinCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }
}
