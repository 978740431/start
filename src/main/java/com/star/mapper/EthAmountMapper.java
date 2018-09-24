package com.star.mapper;

import com.star.model.btc.EthAmount;
import com.star.model.btc.EthAmountQuery;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
public interface EthAmountMapper {

    List<EthAmount> queryList(EthAmountQuery ethAmountQuery);
    List<EthAmount> queryCount(EthAmountQuery ethAmountQuery);
}
