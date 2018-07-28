package com.star.service.btc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/20 下午5:46
 * @Describe
 * @Version
 * @since
 */
public class Test3 {

    private final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.put(i);

                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    int info = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + info);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
