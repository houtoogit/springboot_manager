package com.sky.admin;

/**
 * @Author: H
 * @Date: 2021/3/8 19:32
 * @Version: 1.0.0
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
