package com.star.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangnan on 2016/12/19.
 */
public class TestThreadPoolExecutor {


    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
    /*
        corePoolSize 指的是保留的线程池大小。
        maximumPoolSize 指的是线程池的最大大小。
        keepAliveTime 指的是空闲线程结束的超时时间。
        unit 是一个枚举，表示 keepAliveTime 的单位。
        workQueue 表示存放任务的队列。
    */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 6, 1, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 20; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    /*try {
//                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread()+"1....");

                }
            });
        }
        executor.shutdown();
    }


}
