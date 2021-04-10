package com.example.homework04.thread;


import java.util.concurrent.CountDownLatch;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 通过CountDownLatch获取result的值
 */
public class Homework04CountDownLatchTask {

    private CountDownLatch latch;

    private int sum = 0;

    public Homework04CountDownLatchTask(CountDownLatch latch) {
        this.latch = latch;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        long start = System.currentTimeMillis();
        final Homework04CountDownLatchTask method = new Homework04CountDownLatchTask(latch);

        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            method.sum();
        }).start();
        //启动线程，异步执行方法
        System.out.println("其他业务。。。");
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + method.getValue());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private void sum() {
        sum = fibo(36);
        latch.countDown();
    }

    private int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    public int getValue() throws InterruptedException {
        latch.await();
        return sum;
    }
}
