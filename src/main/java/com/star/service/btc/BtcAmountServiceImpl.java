package com.star.service.btc;

import com.star.mapper.BtcAmountMapper;
import com.star.model.btc.BtcAmount;
import com.star.model.btc.BtcAmountQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/23 下午4:14
 * @Describe
 * @Version
 * @since
 */
@Service
public class BtcAmountServiceImpl implements BtcAmountService {

    private final Log log = LogFactory.getLog(this.getClass());

    @Resource
    private BtcAmountMapper btcAmountMapper;


    public List<BtcAmount> queryBtcAmountList() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
        Date nowDate = new Date();
        String time = format.format(nowDate) + ":00:00";
        SimpleDateFormat todayFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = todayFormat.format(nowDate) + " 00:00:00";

        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        btcAmountQuery.setQueryTime(time);
        btcAmountQuery.setLastHourTime(getLastHourTime(nowDate));
        btcAmountQuery.setTodayTime(today);
        btcAmountQuery.setYesterdayTime(getYesterdayTime(nowDate));
        btcAmountQuery.setSevenTime(getSevenTime(nowDate));

        List<BtcAmount> btcAmountList = btcAmountMapper.queryList(btcAmountQuery);

        return btcAmountList;

    }

    private String getLastHourTime(Date nowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        // 让日期加1
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) - 1);

        return new SimpleDateFormat("yyyy-MM-dd HH").format(calendar.getTime()) + ":00:00";
    }

    private String getYesterdayTime(Date nowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        // 让日期加1
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);

        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()) + " 00:00:00";
    }
    private String getSevenTime(Date nowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        // 让日期加1
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 7);

        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()) + " 00:00:00";
    }


    public static void main(String[] args) {
        String yesterdayTime = new BtcAmountServiceImpl().getSevenTime(new Date());
        System.out.println(yesterdayTime);
    }


}
