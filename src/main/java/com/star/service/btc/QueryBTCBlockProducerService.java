package com.star.service.btc;

import com.star.model.btc.BlockList;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/20 下午11:46
 * @Describe
 * @Version
 * @since
 */
public interface QueryBTCBlockProducerService {

    final BlockingQueue<BlockList> blockingQueue = new ArrayBlockingQueue<BlockList>(30);

}
