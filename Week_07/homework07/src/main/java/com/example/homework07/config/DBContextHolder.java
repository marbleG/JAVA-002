package com.example.homework07.config;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(String dbType) {
        contextHolder.set(dbType);
    }

    public static String get() {
        return contextHolder.get();
    }

    public static void master() {
        set("master");
        System.out.println("切换到master");
    }

    public static void slave() {
        set("slave");
        System.out.println("切换到slave");

    }

}
