package com.star.dao;

import com.star.model.btc.BtcTransactionHistory;

import java.util.List;

/**
 * Created by zhangnan on 16/11/13.
 */
public interface BtcTransactionHistoryDAO {

    void create(BtcTransactionHistory btcTransactionHistory);

    void createBatch(List<BtcTransactionHistory> createHistoryList);
}
