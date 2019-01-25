package com.star.model.btc;

/**
 * @Author 张楠
 * @Date 2019-01-2019/1/13 上午10:55
 * @Describe
 * @Version
 * @since
 */
public class WalletRecordQuery {

    private String coinType;
    private String exchangeName;

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }
}
