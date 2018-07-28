package com.star.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author 张楠
 * @Date 2018-07-2018/7/20 上午11:39
 * @Describe
 * @Version
 * @since
 */
@Service
public class CoinAddAndReduceServiceImpl implements CoinAddAndReduceService{


    @Scheduled(cron = "* * * * * *")
    public void btcAddOrReduce(){
        System.out.println(111);

    }
}
