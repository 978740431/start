package com.star.mapper;

import com.star.model.btc.BtcTransactionHistory;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
public interface BtcTransactionHistoryMapper {

    public void create(BtcTransactionHistory btcTransactionHistory);

    void createBatch(List<BtcTransactionHistory> createHistoryList);
}
