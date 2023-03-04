package com.sky.admin;

import java.util.concurrent.Callable;

/**
 * @Author: H
 * @Date: 2021/3/8 19:18
 * @Version: 1.0.0
 */
public class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 1;
    }
}
