package com.star.dao;

import com.star.model.btc.BtcWallet;
import com.star.model.btc.OutList;

import java.util.List;

/**
 * Created by zhangnan on 16/11/13.
 */
public interface BtcWalletDAO {

    public void createBtcWallet(BtcWallet btcWallet);

    BtcWallet findByAddress(String btcAddress);

    BtcWallet findMaxWalletBlock();

    void reducesBtc(BtcWallet reducesBtc);

    void addBtc(BtcWallet reducesBtc);

    List<BtcWallet> findByAddressList(List<OutList> outList);

    void createBtcWalletBatch(List<BtcWallet> createBtcWalletList);

    void updateBtcWalletAmount(BtcWallet btcWalletForUpdateAmount);

    void updateAmountFromNullToZero();


}
