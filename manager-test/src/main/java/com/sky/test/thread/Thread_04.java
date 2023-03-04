package com.sky.test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Directions 多个线程同时操作一个资源引发的线程安全问题
 * @Author H
 * @Date 2021/5/22 11:00
 * @Version 1.0
 */
@Slf4j
public class Thread_04 implements Runnable{

    private int ticketNumbers = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNumbers <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                log.warn(e.getMessage());
            }
            log.info(Thread.currentThread().getName() + "抢到了第 " + ticketNumbers-- + " 张票");
        }
    }

    public static void main(String[] args) {
        Thread_04 thread_04 = new Thread_04();
        new Thread(thread_04, "老侯").start();
        new Thread(thread_04, "小明").start();
        new Thread(thread_04, "黄牛党").start();
    }
}
