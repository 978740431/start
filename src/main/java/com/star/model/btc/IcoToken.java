package com.star.model.btc;


/**
 * @author
 * @since 2018-06-23
 */
public class IcoToken {

    /**
     * id
     **/
    private Long id;
    /**
     * token_name
     **/
    private String tokenName;
    /**
     * token
     **/
    private String token;
    /**
     * ico_money
     **/
    private Long icoMoney;
    /**
     * current_money
     **/
    private Long currentMoney;
    /**
     * top_have
     **/
    private Long topHave;
    /**
     * ico_number
     **/
    private Long icoNumber;

    private String chartsName;
    private String needCountNumber;

    private Long leastNumber;
    private Integer needShow;

    public IcoToken() {
    }


    public IcoToken(String tokenName, Long icoNumber, String chartsName,Long leastNumber) {
        this.tokenName = tokenName;
        this.icoNumber = icoNumber;
        this.chartsName = chartsName;
        this.leastNumber = leastNumber;
    }

    public IcoToken(String tokenName, String token, Long icoMoney, Long currentMoney, Long topHave, Long icoNumber) {
        this.tokenName = tokenName;
        this.token = token;
        this.icoMoney = icoMoney;
        this.currentMoney = currentMoney;
        this.topHave = topHave;
        this.icoNumber = icoNumber;
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
     * 获取属性:token
     * token
     *
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置属性:token
     * token
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取属性:icoMoney
     * ico_money
     *
     * @return icoMoney
     */
    public Long getIcoMoney() {
        return icoMoney;
    }

    /**
     * 设置属性:icoMoney
     * ico_money
     *
     * @param icoMoney
     */
    public void setIcoMoney(Long icoMoney) {
        this.icoMoney = icoMoney;
    }

    /**
     * 获取属性:currentMoney
     * current_money
     *
     * @return currentMoney
     */
    public Long getCurrentMoney() {
        return currentMoney;
    }

    /**
     * 设置属性:currentMoney
     * current_money
     *
     * @param currentMoney
     */
    public void setCurrentMoney(Long currentMoney) {
        this.currentMoney = currentMoney;
    }

    /**
     * 获取属性:topHave
     * top_have
     *
     * @return topHave
     */
    public Long getTopHave() {
        return topHave;
    }

    /**
     * 设置属性:topHave
     * top_have
     *
     * @param topHave
     */
    public void setTopHave(Long topHave) {
        this.topHave = topHave;
    }

    /**
     * 获取属性:icoNumber
     * ico_number
     *
     * @return icoNumber
     */
    public Long getIcoNumber() {
        return icoNumber;
    }

    /**
     * 设置属性:icoNumber
     * ico_number
     *
     * @param icoNumber
     */
    public void setIcoNumber(Long icoNumber) {
        this.icoNumber = icoNumber;
    }

    public String getChartsName() {
        return chartsName;
    }

    public void setChartsName(String chartsName) {
        this.chartsName = chartsName;
    }

    public String getNeedCountNumber() {
        return needCountNumber;
    }

    public void setNeedCountNumber(String needCountNumber) {
        this.needCountNumber = needCountNumber;
    }

    public Long getLeastNumber() {
        return leastNumber;
    }

    public void setLeastNumber(Long leastNumber) {
        this.leastNumber = leastNumber;
    }

    public Integer getNeedShow() {
        return needShow;
    }

    public void setNeedShow(Integer needShow) {
        this.needShow = needShow;
    }
}