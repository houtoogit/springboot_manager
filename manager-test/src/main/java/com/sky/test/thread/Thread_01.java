package com.sky.test.thread;

/**
 * @Directions 线程测试
 * @Author H
 * @Date 2021/4/27 23:26
 * @Version 1.0
 */
public class Thread_01 {

    public synchronized static void num() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i + "  houtoo");
        }
    }

    public static void main(String[] args) {
        new Thread(Thread_01::num, "one").start();
        new Thread(Thread_01::num, "two").start();
    }

}
