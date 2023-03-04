package com.sky.test.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * @Directions 格式化时间/日期
 * @Author H
 * @Date 2021/4/11 20:34
 * @Version 1.0
 */
public class TestDateFormatter {
    public static void main(String[] args) {
        DateTimeFormatter dtf_01 = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter dtf_02 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String format_01 = time.format(dtf_01);
        String format_02 = dtf_02.format(time);
        System.out.println(format_01);
        System.out.println(format_02);
        LocalDateTime dateTime = time.parse(format_02, dtf_02);
        System.out.println(dateTime);
        System.out.println("-----------------------------");
        Set<String> ids = ZoneId.getAvailableZoneIds();
//        ids.forEach(System.out::println);
        ids.forEach(id -> {if (id.equals("America/Cuiaba")) System.out.println(id);});
    }
}
