package com.star.mapper;

import com.star.model.btc.*;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
public interface WalletRecordMapper {


    List<WalletRecord> queryList(WalletRecordQuery btcAmountQuery);
}
