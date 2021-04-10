package com.example.homework04.thread;


import java.util.concurrent.*;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 通过执行器获取result的值
 */
public class Homework03Executor implements Callable<Integer> {
    private static final ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        Homework03Executor future = new Homework03Executor();
        //通过线程池提交异步任务
        Future<Integer> submit = service.submit(future);
        System.out.println("其他业务。。。");
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ submit.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        service.shutdown();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    @Override
    public Integer call() throws Exception {
        return sum();
    }
}
