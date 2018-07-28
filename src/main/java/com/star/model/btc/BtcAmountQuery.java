package com.star.model.btc;


import java.util.Date;
import java.util.List;

/**
 *
 * @author 
 * @since 2018-06-24
 */
public class BtcAmountQuery {

	/** id **/
	private Long id;
	/** btc_address **/
	private String btcAddress;
	/** btc_count **/
	private Long btcCount;
	/** btc_percent **/
	private String btcPercent;
	/** create_time **/
	private Date createTime;
	/** ranking **/
	private Integer ranking;

	private String queryTime;
	private String lastHourTime;
	private String todayTime;
	private String yesterdayTime;
	private String sevenTime;
	private String coinType;
	private Integer dataType;
	List<String> needIcoTokenList;

	public BtcAmountQuery() {}

	public BtcAmountQuery(String btcAddress, Long btcCount, String btcPercent, Date createTime, Integer ranking) {
		this.btcAddress=btcAddress;
		this.btcCount=btcCount;
		this.btcPercent=btcPercent;
		this.createTime=createTime;
		this.ranking=ranking;
		}


	/**
	 * 获取属性:id
	 * id
	 * @return id
	 */
	public Long getId() {
        return id;
	}
	/**
	 * 设置属性:id
	 * id
	 * @param id
	 */
	public void setId(Long id) {
        this.id = id;
	}

	/**
	 * 获取属性:btcAddress
	 * btc_address
	 * @return btcAddress
	 */
	public String getBtcAddress() {
        return btcAddress;
	}
	/**
	 * 设置属性:btcAddress
	 * btc_address
	 * @param btcAddress
	 */
	public void setBtcAddress(String btcAddress) {
        this.btcAddress = btcAddress;
	}

	/**
	 * 获取属性:btcCount
	 * btc_count
	 * @return btcCount
	 */
	public Long getBtcCount() {
        return btcCount;
	}
	/**
	 * 设置属性:btcCount
	 * btc_count
	 * @param btcCount
	 */
	public void setBtcCount(Long btcCount) {
        this.btcCount = btcCount;
	}

	/**
	 * 获取属性:btcPercent
	 * btc_percent
	 * @return btcPercent
	 */
	public String getBtcPercent() {
        return btcPercent;
	}
	/**
	 * 设置属性:btcPercent
	 * btc_percent
	 * @param btcPercent
	 */
	public void setBtcPercent(String btcPercent) {
        this.btcPercent = btcPercent;
	}

	/**
	 * 获取属性:createTime
	 * create_time
	 * @return createTime
	 */
	public Date getCreateTime() {
        return createTime;
	}
	/**
	 * 设置属性:createTime
	 * create_time
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
	}

	/**
	 * 获取属性:ranking
	 * ranking
	 * @return ranking
	 */
	public Integer getRanking() {
        return ranking;
	}
	/**
	 * 设置属性:ranking
	 * ranking
	 * @param ranking
	 */
	public void setRanking(Integer ranking) {
        this.ranking = ranking;
	}

	public String getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}

	public String getLastHourTime() {
		return lastHourTime;
	}

	public void setLastHourTime(String lastHourTime) {
		this.lastHourTime = lastHourTime;
	}

	public String getTodayTime() {
		return todayTime;
	}

	public void setTodayTime(String todayTime) {
		this.todayTime = todayTime;
	}

	public String getYesterdayTime() {
		return yesterdayTime;
	}

	public void setYesterdayTime(String yesterdayTime) {
		this.yesterdayTime = yesterdayTime;
	}

	public String getSevenTime() {
		return sevenTime;
	}

	public void setSevenTime(String sevenTime) {
		this.sevenTime = sevenTime;
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


	public List<String> getNeedIcoTokenList() {
		return needIcoTokenList;
	}

	public void setNeedIcoTokenList(List<String> needIcoTokenList) {
		this.needIcoTokenList = needIcoTokenList;
	}
}