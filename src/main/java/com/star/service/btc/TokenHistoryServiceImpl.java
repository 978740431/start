package com.star.service.btc;

import com.star.dao.TokenHistoryDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/20 下午5:46
 * @Describe
 * @Version
 * @since
 */
@Service
public class TokenHistoryServiceImpl implements QueryBTCBlockV2Service {


    @Resource
    private TokenHistoryDAO tokenHistoryDAO;


    public static void main(String[] args) {
    }

    public void create(){



    }

}
