package com.star.dao;

import com.star.mapper.TokenHistoryMapper;
import com.star.model.btc.TokenHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2016/6/18.
 */
@Repository("tokenHistoryDAO")
public class TokenHistoryDAOImpl implements TokenHistoryDAO {


    @Autowired
    private TokenHistoryMapper tokenHistoryMapper;


    public void create(TokenHistory tokenHistory){

        tokenHistoryMapper.create(tokenHistory);
    }
}
