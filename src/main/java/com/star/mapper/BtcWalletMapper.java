package com.star.mapper;

import com.star.model.btc.BtcWallet;
import com.star.model.btc.OutList;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
public interface BtcWalletMapper {


    void createBtcWallet(BtcWallet btcWallet);

    BtcWallet findByAddress(String btcAddress);

    BtcWallet findMaxWalletBlock();

    void addBtc(BtcWallet reducesBtc);

    void reducesBtc(BtcWallet reducesBtc);

    List<BtcWallet> findByAddressList(List<OutList> outList);

    void createBtcWalletBatch(List<BtcWallet> createBtcWalletList);

    void updateBtcWalletAmount(BtcWallet btcWalletForUpdateAmount);

    void updateAmountFromNullToZero();


}
