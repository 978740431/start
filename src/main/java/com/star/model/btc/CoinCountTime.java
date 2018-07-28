package com.star.model.btc;

/**
 * @Author 张楠
 * @Date 2018-07-2018/7/23 下午9:46
 * @Describe
 * @Version
 * @since
 */
public class CoinCountTime {


    private Long coinCount;
    private String createTime;
    private String coinType;
    private Integer dataType;


    public Long getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Long coinCount) {
        this.coinCount = coinCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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
