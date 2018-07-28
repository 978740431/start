package com.star.mapper;

import com.star.model.btc.BtcAmount;
import com.star.model.btc.BtcAmountQuery;
import com.star.model.btc.CoinCountTime;
import com.star.model.btc.CoinCountTimeQuery;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
public interface CoinCountTimeMapper {

    List<BtcAmount> queryTopList(BtcAmountQuery btcAmountQuery);

    List<CoinCountTime> queryTopListV2(CoinCountTimeQuery btcAmountQuery);

}
