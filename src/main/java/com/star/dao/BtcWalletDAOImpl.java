package com.star.dao;

import com.star.mapper.BtcWalletMapper;
import com.star.model.btc.BtcWallet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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
}
