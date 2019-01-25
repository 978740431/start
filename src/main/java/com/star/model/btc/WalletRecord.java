package com.star.model.btc;

import java.util.Date;

/**
 * @Author 张楠
 * @Date 2019-01-2019/1/13 上午10:54
 * @Describe
 * @Version
 * @since
 */
public class WalletRecord {

    private Long coinCount;
    private Date recordTime;
    private String coinType;
    private String walletName;
    private String outRecordTime;


    public Long getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Long coinCount) {
        this.coinCount = coinCount;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getOutRecordTime() {
        return outRecordTime;
    }

    public void setOutRecordTime(String outRecordTime) {
        this.outRecordTime = outRecordTime;
    }
}
