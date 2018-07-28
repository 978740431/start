package com.star.dao;

import com.star.mapper.BtcTransactionHistoryMapper;
import com.star.model.btc.BtcTransactionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
@Repository("btcTransactionHistoryDAO")
public class BtcTransactionHistoryDAOImpl implements BtcTransactionHistoryDAO {


    @Autowired
    private BtcTransactionHistoryMapper btcTransactionHistoryMapper;


    public void create(BtcTransactionHistory btcTransactionHistory){

        btcTransactionHistoryMapper.create(btcTransactionHistory);
    }

    @Override
    public void createBatch(List<BtcTransactionHistory> createHistoryList) {
        btcTransactionHistoryMapper.createBatch(createHistoryList);
    }

}
