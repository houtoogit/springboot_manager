package com.sky.test.stream;

import com.sky.test.entity.Trader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Directions Fork Join
 * @Author H
 * @Date 2021/4/11 09:50
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestForkJoin {

    @Test
    public void test_01() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask task = new ForkJoinCalculate(0, 100000000L);
        Long invoke = (Long) pool.invoke(task);
        System.out.println(invoke);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test_02() {
        Instant start = Instant.now();
        long sum = 0L;
        for (int i = 0; i <= 100000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test_03() {
        Instant start = Instant.now();
        LongStream.rangeClosed(0, 100000000000L).parallel().reduce(Long::sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis() / 1000);
    }

    @Test
    public void test_04() {

        Trader trader = null;
        Trader trader_01 = new Trader();

        trader_01.setCity("chengdu").setName("houtoo");

        log.info("trader_01 -> " +  trader_01);

        trader = trader_01;

        trader.setCity("bazhong").setName("china");

        log.info("trader -> " +  trader);
        log.info("trader_01 -> " +  trader_01);

    }

}
