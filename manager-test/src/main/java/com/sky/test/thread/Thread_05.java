package com.sky.test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Directions 多线程练习 龟兔赛跑
 * @Author H
 * @Date 2021/5/22 11:28
 * @Version 1.0
 */
@Slf4j
public class Thread_05 implements Runnable {

    // 胜利者
    private static String winner;

    // 判断比赛是否结束
    private boolean isGameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                log.info("winner is: " + winner);
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            log.info(Thread.currentThread().getName() + " 已经跑了 " + i + "步");

            // 模拟兔子睡觉
            if (Thread.currentThread().getName().equals("兔子") && i % 90 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    log.warn(e.getMessage());
                }
            }

            boolean over = isGameOver(i);
            if (over) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Thread_05 thread_05 = new Thread_05();
        new Thread(thread_05, "兔子").start();
        new Thread(thread_05, "乌龟").start();
    }
}
