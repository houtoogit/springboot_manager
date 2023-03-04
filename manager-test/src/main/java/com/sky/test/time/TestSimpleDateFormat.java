package com.sky.test.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Directions 多线程时间格式解析
 * @Author H
 * @Date 2021/4/11 14:35
 * @Version 1.0
 */
public class TestSimpleDateFormat {

    public static void main(String[] args) throws Exception {
        Date date = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Callable<String> task = () -> sdf.format(date);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(pool.submit(task));
        }

        for (Future<String> future : list) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }

}
