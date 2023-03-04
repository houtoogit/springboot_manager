package com.sky.test.time;

import java.time.*;

/**
 * @Directions java 8 时间和日期 API
 * @Author H
 * @Date 2021/4/11 14:56
 * @Version 1.0
 */
public class TestLocalDateTime {

    public static void main(String[] args) throws InterruptedException {
        // LocalDate LocalTime LocalDateTime
        // 人类能看懂的时间操作
        LocalDateTime time_01 = LocalDateTime.now();
        System.out.println(time_01);

        LocalDateTime time_02 = LocalDateTime.of(2021, 4, 10, 19, 39, 50, 786);
        System.out.println(time_02);

        LocalDateTime time_03 = time_01.plusYears(10);
        System.out.println(time_03);

        LocalDateTime time_04 = time_01.minusMonths(5);
        System.out.println(time_04);

        System.out.println(time_01.getYear());
        System.out.println(time_01.getMonth());
        System.out.println(time_01.getMonthValue());
        System.out.println(time_01.getDayOfMonth());
        System.out.println(time_01.getDayOfWeek());
        System.out.println(time_01.getDayOfYear());
        System.out.println(time_01.getHour());
        System.out.println(time_01.getMinute());
        System.out.println(time_01.getSecond());

        // Instant : 时间戳（以unix元年 - 1970年1月1日 00:00:00）
        // 默认获取utc时区
        Instant ins_01 = Instant.now();
        System.out.println(ins_01);

        OffsetDateTime ins_02 = ins_01.atOffset(ZoneOffset.ofHours(8));
        System.out.println(ins_02);
        System.out.println(ins_01.toEpochMilli());

        Instant ins_03 = Instant.ofEpochSecond(60);
        System.out.println(ins_03);

        // Duration: 计算两个时间之间的间隔
        Instant instant_01 = Instant.now();
        Thread.sleep(1);
        Instant instant_02 = Instant.now();
        long millis = Duration.between(instant_01, instant_02).toMillis();
        System.out.println(millis);
        System.out.println(LocalTime.now());

        // Period: 计算两个日期之间的间隔
        LocalDate date_01 = LocalDate.of(2015, 10, 1);
        LocalDate date_02 = LocalDate.now();
        Period period = Period.between(date_01, date_02);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

}
