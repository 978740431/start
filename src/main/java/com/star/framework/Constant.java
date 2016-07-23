package com.star.framework;


import java.io.InputStream;
import java.util.Properties;

/**
 * @author yuwei
 * @time 2015-10-15上午09:22:33
 */
public abstract class Constant {
	public static final String LOCALE_ZH_CN = "zh_CN";
	public static final String LOCALE_EN_US = "en_US";
	public static final String GLOBAL_TO_SUCCESS = "global.to.success";
	public static final String GLOBAL_TO_ERROR = "global.to.error";
	public static final String GLOBAL_TO_LOGIN = "global.to.login";
	public static final String IMG_TYPE_JPG = ".jpg";
	public static final String COOKIE_MEMBER_NAME = "cookie.member.name";
	public static final String USER_UUID = "uuid";
	public static final String USER_TYPE = "utype";
	public static final String USER_TYPE_ADMIN = "1";//管理员
	public static final String USER_TYPE_USER = "2";//注册用户
	public static final String SESSION_USER_ID = "sessionUserId";
	public static final float MAX_BARGAIN = 1.3f;//站点无人出单时的默认议价
	public static final int MAX_DISTANCE = 10000;//保洁师最远接单距离(自动派单)
	public static final int PAGE_MAX_DISTANCE = 5000;//牛家帮app首页 要显示的保洁师到客户定位位置的最大距离。
	public static final int PAGE_MAX_PERSONNUM = 50;//牛家帮app首页 最多显示多少个符合条件的保洁师。
	public static final String MINTIME_BETWEENORDERS = "01:30:00";//两个订单之间最少间隔时间
	public static final int MAX_DISTANCE_MANUAL = 50000;//保洁师最远接单距离(手工派单)
	public static final int OUTMAX_DISTANCE = 100000;//外包单最远接单距离
	public static final int HOURS = 90;//路程时间
	public static final int HOURS2 = 180;//提前预约时间
	public static final String OUTSERVICEBARGAIN ="18:00" ;//外包单截止到该时间不接第二天订单;
	public static final String OUT_SERVICE_PRO = "1_31,1_21,1_35,1_36,1_30,1_28";//1上海 2深圳 3杭州 外包 城市_服务产品串(目前已弃用)
	public static final int DEFAULT_PAGE_SIZE = 10;//每页默认显示条数
	public static final int DEFAULT_MAX_PAGE_SIZE = 65535;//每页最大行数
	public static final int START_NUM = 1;//默认显示第一页数据
	public static final String START_TIME="08:00"; //结束时间
	public static final String END_TIME="21:30"; //结束时间
	public static final String[] EXCLUDE_DATE={"2016-02-07","2016-02-08","2016-02-09"}; //排班排除日期（例如春节期间，排除日期一律显示为约满）
	public static final long DEFAULT_USER_ID = -999;
	/**
	 * 众包平台支付sn的前缀
	 */
	public static final String PREFIX_PAY_SN_CS = "Z";
	/**
	 * 出行平台支付sn的前缀
	 */
	public static final String PREFIX_PAY_SN_TRAVEL = "T";
	/**
	 * 洗衣平台支付sn的前缀
	 */
	public static final String PREFIX_PAY_SN_WASH_CLOTHES = "X";

	/**
	 * 众包平台的渠道(lq)
	 */
	public static final String CS_CHANNEL_LQ = "lq";
	/**
	 * 出行平台的渠道(miu)
	 */
	public static final String TRAVEL_CHANNEL_MIU = "miu";
	/**
	 * 洗衣平台的渠道(fornet)
	 */
	public static final String WASHCLOTHES_CHANNEL_FORNET = "fornet";

	/**
	 * 站点地址key
	 */
	public static final String CONTEXT_PATH_KEY = "contextPath";
	/**
	 * 静态资源地址key
	 */
	public static final String STATIC_PATH_KEY = "staticPath";




	/**
	 * 静态资源地址
	 */
	public static String STATIC_PATH = "";


	protected static Properties pro = new Properties();
	public static int SERVER_NO = 0;

	public static int AUTO_REFUND_SMS = 0;


	static {
		try {
			InputStream is = Constant.class.getClassLoader().getResourceAsStream("constants.properties");
			pro.load(is);
			STATIC_PATH = pro.getProperty("STATIC_PATH");
			SERVER_NO = Integer.parseInt(pro.getProperty("SERVER_NO"));
			AUTO_REFUND_SMS = Integer.parseInt(pro.getProperty("AUTO_REFUND_SMS"));
		} catch (Exception e) {
		}
	}
	
}
