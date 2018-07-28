package com.star.dao;

import com.star.mapper.BtcWalletMapper;
import com.star.model.btc.BtcWallet;
import com.star.model.btc.OutList;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
@Repository("btcWalletDAO")
public class BtcWalletDAOImpl implements BtcWalletDAO {


    @Resource
    private BtcWalletMapper btcWalletMapper;

    @Override
    public void createBtcWallet(BtcWallet btcWallet){
        btcWalletMapper.createBtcWallet(btcWallet);
    }

    @Override
    public BtcWallet findByAddress(String btcAddress) {
        return btcWalletMapper.findByAddress(btcAddress);
    }

    @Override
    public BtcWallet findMaxWalletBlock() {
        return btcWalletMapper.findMaxWalletBlock();
    }

    @Override
    public void reducesBtc(BtcWallet reducesBtc) {
        btcWalletMapper.reducesBtc(reducesBtc);
    }

    @Override
    public void addBtc(BtcWallet reducesBtc) {
        btcWalletMapper.addBtc(reducesBtc);
    }

    @Override
    public List<BtcWallet> findByAddressList(List<OutList> outList) {
        return btcWalletMapper.findByAddressList(outList);
    }

    @Override
    public void createBtcWalletBatch(List<BtcWallet> createBtcWalletList) {
        btcWalletMapper.createBtcWalletBatch(createBtcWalletList);
    }

    @Override
    public void updateBtcWalletAmount(BtcWallet btcWalletForUpdateAmount) {
        btcWalletMapper.updateBtcWalletAmount(btcWalletForUpdateAmount);
    }

    @Override
    public void updateAmountFromNullToZero() {
        btcWalletMapper.updateAmountFromNullToZero();
    }
}
