package com.star.model.btc;


/**
 * @author
 * @since 2018-06-17
 */
public class BtcWallet {

    /**
     * id
     **/
    private Long id;
    /**
     * 钱包号,
     **/
    private Long blockId;
    /**
     * btc钱包地址
     **/
    private String btcAddress;
    /**
     * 钱包金额,单位待定
     **/
    private Long btcAmount;
    /**
     * 钱包的创建时间
     **/
    private String createTime;

    public BtcWallet() {
    }

    public BtcWallet(Long blockId, String btcAddress, Long btcAmount, String createTime) {
        this.blockId = blockId;
        this.btcAddress = btcAddress;
        this.btcAmount = btcAmount;
        this.createTime = createTime;
    }


    /**
     * 获取属性:id
     * id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置属性:id
     * id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取属性:blockId
     * 钱包号,
     *
     * @return blockId
     */
    public Long getBlockId() {
        return blockId;
    }

    /**
     * 设置属性:blockId
     * 钱包号,
     *
     * @param blockId
     */
    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    /**
     * 获取属性:btcAddress
     * btc钱包地址
     *
     * @return btcAddress
     */
    public String getBtcAddress() {
        return btcAddress;
    }

    /**
     * 设置属性:btcAddress
     * btc钱包地址
     *
     * @param btcAddress
     */
    public void setBtcAddress(String btcAddress) {
        this.btcAddress = btcAddress;
    }

    /**
     * 获取属性:btcAmount
     * 钱包金额,单位待定
     *
     * @return btcAmount
     */
    public Long getBtcAmount() {
        return btcAmount;
    }

    /**
     * 设置属性:btcAmount
     * 钱包金额,单位待定
     *
     * @param btcAmount
     */
    public void setBtcAmount(Long btcAmount) {
        this.btcAmount = btcAmount;
    }

    /**
     * 获取属性:createTime
     * 钱包的创建时间
     *
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置属性:createTime
     * 钱包的创建时间
     *
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}