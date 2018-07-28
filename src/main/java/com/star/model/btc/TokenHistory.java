package com.star.model.btc;


import java.util.Date;

/**
 * @author
 * @since 2018-06-22
 */
public class TokenHistory {

    /**
     * id
     **/
    private Long id;
    /**
     * token_name
     **/
    private String tokenName;
    /**
     * token_address
     **/
    private String tokenAddress;
    /**
     * create_time
     **/
    private Date createTime;
    /**
     * 数量
     **/
    private Long quantity;
    /**
     * 占比
     **/
    private Integer percentage;
    /**
     * user_address
     **/
    private String userAddress;

    public TokenHistory() {
    }

    public TokenHistory(String tokenName, String tokenAddress, Date createTime, Long quantity, Integer percentage, String userAddress) {
        this.tokenName = tokenName;
        this.tokenAddress = tokenAddress;
        this.createTime = createTime;
        this.quantity = quantity;
        this.percentage = percentage;
        this.userAddress = userAddress;
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
     * 获取属性:tokenName
     * token_name
     *
     * @return tokenName
     */
    public String getTokenName() {
        return tokenName;
    }

    /**
     * 设置属性:tokenName
     * token_name
     *
     * @param tokenName
     */
    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    /**
     * 获取属性:tokenAddress
     * token_address
     *
     * @return tokenAddress
     */
    public String getTokenAddress() {
        return tokenAddress;
    }

    /**
     * 设置属性:tokenAddress
     * token_address
     *
     * @param tokenAddress
     */
    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    /**
     * 获取属性:createTime
     * create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置属性:createTime
     * create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取属性:quantity
     * 数量
     *
     * @return quantity
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * 设置属性:quantity
     * 数量
     *
     * @param quantity
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取属性:percentage
     * 占比
     *
     * @return percentage
     */
    public Integer getPercentage() {
        return percentage;
    }

    /**
     * 设置属性:percentage
     * 占比
     *
     * @param percentage
     */
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    /**
     * 获取属性:userAddress
     * user_address
     *
     * @return userAddress
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置属性:userAddress
     * user_address
     *
     * @param userAddress
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

}