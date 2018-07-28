package com.star.model.btc;

import java.util.List;

/**
 * @Author 张楠
 * @Date 2018-07-2018/7/23 下午9:46
 * @Describe
 * @Version
 * @since
 */
public class CoinCountTimeQuery {


    private Integer coinCount;
    private String createTime;
    private Integer coinType;
    private Integer dataType;
    private Integer excludeFirstAddress;
    private List<String> needIcoTokenList;


    public Integer getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Integer coinCount) {
        this.coinCount = coinCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCoinType() {
        return coinType;
    }

    public void setCoinType(Integer coinType) {
        this.coinType = coinType;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public List<String> getNeedIcoTokenList() {
        return needIcoTokenList;
    }

    public void setNeedIcoTokenList(List<String> needIcoTokenList) {
        this.needIcoTokenList = needIcoTokenList;
    }


    public Integer getExcludeFirstAddress() {
        return excludeFirstAddress;
    }

    public void setExcludeFirstAddress(Integer excludeFirstAddress) {
        this.excludeFirstAddress = excludeFirstAddress;
    }
}
