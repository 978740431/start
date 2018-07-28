package com.star.mapper;

import com.star.model.btc.BtcAmount;
import com.star.model.btc.BtcAmountQuery;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
public interface BtcAmountMapper {

    List<BtcAmount> queryList(BtcAmountQuery btcAmountQuery);
    List<BtcAmount> queryTopList(BtcAmountQuery btcAmountQuery);
}
