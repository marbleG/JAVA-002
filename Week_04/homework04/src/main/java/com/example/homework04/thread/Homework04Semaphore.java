package com.example.homework04.thread;


import java.util.concurrent.Semaphore;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 通过Semaphore获取result的值
 */
public class Homework04Semaphore {
    private int sum = 0;
    private final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Homework04Semaphore homework04Semaphore = new Homework04Semaphore();
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        homework04Semaphore.semaphore.acquireUninterruptibly();
        new Thread(() -> {
            homework04Semaphore.sum();
        }).start();
        //启动线程，异步执行方法
        System.out.println("其他业务。。。");
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + homework04Semaphore.getValue());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private void sum() {
        try {
            sum = fibo(36);
        } finally {
            semaphore.release();
        }
    }

    private int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    public int getValue() throws InterruptedException {
        try {
            semaphore.acquireUninterruptibly();
            return sum;
        } finally {
            semaphore.release();

        }
    }
}
