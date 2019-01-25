package com.star.model.btc;


import java.util.Date;

/**
 *
 * @author 
 * @since 2018-06-24
 */
public class BtcAmount {

	/** id **/
	private Long id;
	/** btc_address **/
	private String btcAddress;
	/** btc_count **/
	private Long btcCount;
	/** btc_percent **/
	private String btcPercent;
	private String createYear;
	private String createMonthDay;
	private String createHourMinute;
	/** create_time **/
	private Date createTime;
	/** ranking **/
	private Integer ranking;

	private Integer lastHourBtcCount;
	private Integer todayBtcCount;
	private Integer yesterdayBtcCount;
	private Integer sevenBtcCount;

	public BtcAmount() {}

	public BtcAmount(String btcAddress, Long btcCount, String btcPercent, Date createTime, Integer ranking ) {
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


	public Integer getLastHourBtcCount() {
		return lastHourBtcCount;
	}

	public void setLastHourBtcCount(Integer lastHourBtcCount) {
		this.lastHourBtcCount = lastHourBtcCount;
	}

	public Integer getTodayBtcCount() {
		return todayBtcCount;
	}

	public void setTodayBtcCount(Integer todayBtcCount) {
		this.todayBtcCount = todayBtcCount;
	}

	public Integer getYesterdayBtcCount() {
		return yesterdayBtcCount;
	}

	public void setYesterdayBtcCount(Integer yesterdayBtcCount) {
		this.yesterdayBtcCount = yesterdayBtcCount;
	}

	public Integer getSevenBtcCount() {
		return sevenBtcCount;
	}

	public void setSevenBtcCount(Integer sevenBtcCount) {
		this.sevenBtcCount = sevenBtcCount;
	}

	public String getCreateYear() {
		return createYear;
	}

	public void setCreateYear(String createYear) {
		this.createYear = createYear;
	}

	public String getCreateMonthDay() {
		return createMonthDay;
	}

	public void setCreateMonthDay(String createMonthDay) {
		this.createMonthDay = createMonthDay;
	}

	public String getCreateHourMinute() {
		return createHourMinute;
	}

	public void setCreateHourMinute(String createHourMinute) {
		this.createHourMinute = createHourMinute;
	}
}