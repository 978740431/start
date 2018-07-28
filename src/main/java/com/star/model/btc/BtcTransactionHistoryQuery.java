package com.star.model.btc;


/**
 * @author
 * @since 2018-06-17
 */
public class BtcTransactionHistoryQuery {

    /**
     * id
     **/
    private Long id;
    /**
     * 进地址
     **/
    private String inputAddress;
    /**
     * 出地址
     **/
    private String outAddress;
    /**
     * 区块创建时间
     **/
    private String createTime;
    /**
     * 交易金额
     **/
    private Long btcAmount;
    /**
     * 区块高度
     **/
    private Long height;
    /**
     * hash地址
     **/
    private String hash;

    public BtcTransactionHistoryQuery() {
    }

    public BtcTransactionHistoryQuery(String inputAddress, String outAddress, String createTime, Long btcAmount, Long height, String hash) {
        this.inputAddress = inputAddress;
        this.outAddress = outAddress;
        this.createTime = createTime;
        this.btcAmount = btcAmount;
        this.height = height;
        this.hash = hash;
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
     * 获取属性:inputAddress
     * 进地址
     *
     * @return inputAddress
     */
    public String getInputAddress() {
        return inputAddress;
    }

    /**
     * 设置属性:inputAddress
     * 进地址
     *
     * @param inputAddress
     */
    public void setInputAddress(String inputAddress) {
        this.inputAddress = inputAddress;
    }

    /**
     * 获取属性:outAddress
     * 出地址
     *
     * @return outAddress
     */
    public String getOutAddress() {
        return outAddress;
    }

    /**
     * 设置属性:outAddress
     * 出地址
     *
     * @param outAddress
     */
    public void setOutAddress(String outAddress) {
        this.outAddress = outAddress;
    }

    /**
     * 获取属性:createTime
     * 区块创建时间
     *
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置属性:createTime
     * 区块创建时间
     *
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取属性:btcAmount
     * 交易金额
     *
     * @return btcAmount
     */
    public Long getBtcAmount() {
        return btcAmount;
    }

    /**
     * 设置属性:btcAmount
     * 交易金额
     *
     * @param btcAmount
     */
    public void setBtcAmount(Long btcAmount) {
        this.btcAmount = btcAmount;
    }

    /**
     * 获取属性:height
     * 区块高度
     *
     * @return height
     */
    public Long getHeight() {
        return height;
    }

    /**
     * 设置属性:height
     * 区块高度
     *
     * @param height
     */
    public void setHeight(Long height) {
        this.height = height;
    }

    /**
     * 获取属性:hash
     * hash地址
     *
     * @return hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * 设置属性:hash
     * hash地址
     *
     * @param hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

}