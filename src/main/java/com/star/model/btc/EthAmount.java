package com.star.model.btc;


/**
 *
 * @author 
 * @since 2018-06-24
 */
public class EthAmount {

	/** id **/
	private Long id;
	/** btc_address **/
	private String ethAddress;
	/** btc_count **/
	private Long ethCount;
	/** btc_percent **/
	private String ethPercent;
	/** create_time **/
	private String createTime;
	/** ranking **/
	private Integer ranking;

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
}