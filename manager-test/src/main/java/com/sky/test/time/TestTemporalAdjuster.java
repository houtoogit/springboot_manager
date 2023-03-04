package com.sky.test.time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @Directions 时间校正器
 * @Author H
 * @Date 2021/4/11 20:13
 * @Version 1.0
 */
public class TestTemporalAdjuster {

    public static void main(String[] args) {
        LocalDateTime time_01 = LocalDateTime.now();
        System.out.println(time_01);
        System.out.println(time_01.withDayOfMonth(30));
        System.out.println(time_01.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)));
        System.out.println(time_01.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println(time_01.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));
        LocalDateTime time_02 = time_01.with(time -> {
            LocalDateTime time_03 = (LocalDateTime) time;
            DayOfWeek day = time_03.getDayOfWeek();
            if (day.equals(DayOfWeek.MONDAY)) {
                return time_03.plusDays(5);
            } else {
                return time_03.plusDays(1);
            }
        });
        System.out.println(time_02);
    }

}
