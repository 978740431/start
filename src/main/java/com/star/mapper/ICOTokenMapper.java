package com.star.mapper;

import com.star.model.btc.IcoToken;
import com.star.model.btc.IcoTokenQuery;

import java.util.List;

/**
 * Created by zhangnan on 16/11/24.
 */
public interface ICOTokenMapper {


    void createAllToken(List<IcoToken> coingeckoToken);

    List<IcoToken> findNeedList(IcoTokenQuery icoTokenQuery);
}

