package com.star.model.btc;


import java.util.Date;
import java.util.List;

/**
 *
 * @author 
 * @since 2018-06-24
 */
public class EthAmountQuery {

	/** id **/
	private Long id;
	/** btc_address **/
	private String ethAddress;
	/** btc_count **/
	private Long ethCount;
	/** btc_percent **/
	private String ethPercent;
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
	private String orderStr;
	private Integer dataType;
	List<String> needIcoTokenList;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEthAddress() {
		return ethAddress;
	}

	public void setEthAddress(String ethAddress) {
		this.ethAddress = ethAddress;
	}

	public Long getEthCount() {
		return ethCount;
	}

	public void setEthCount(Long ethCount) {
		this.ethCount = ethCount;
	}

	public String getEthPercent() {
		return ethPercent;
	}

	public void setEthPercent(String ethPercent) {
		this.ethPercent = ethPercent;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getRanking() {
		return ranking;
	}

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

	public String getOrderStr() {
		return orderStr;
	}

	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}
}