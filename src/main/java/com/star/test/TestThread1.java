package com.star.test;

/**
 * Created by zhangnan on 2016/12/19.
 *
 *
 * 例1:
 * 说明:
 *  1.实现runnable的流程.
 *      1.在run()里面写逻辑
 *      2.new run()所在的类对象,然后将该对象放入Thread中,调用Thread.start()方法
 *      3.没有第二部的话直接new TestThread1().run()只是单线程普通的new了一下,调用里面的方法
 *      4.也就是说,还是通过Thread开启的线程
 *  2.Thread实现了Runnable
 */
public class TestThread1 implements Runnable {

    private String thread;

    public TestThread1(String thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我使用runable创建了一个线程=======" + thread);
        }
    }


    public static void main(String[] args) {

        TestThread1 testThread1 = new TestThread1("线程1");
        Thread thread1=new Thread(testThread1);
        thread1.start();

        TestThread1 testThread12 = new TestThread1("线程2");
        Thread thread2=new Thread(testThread12);
        thread2.start();
    }
}
