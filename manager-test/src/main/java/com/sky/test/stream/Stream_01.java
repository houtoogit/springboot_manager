package com.sky.test.stream;

import com.sky.test.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Directions 创建流
 * @Author H
 * @Date 2021/4/4 14:20
 * @Version 1.0
 */
public class Stream_01 {

    public static void main(String[] args) {
        // 可以通过 collection 系列集合提供的 stream() 或 parallelStream()
        Stream<String> stream_01 = new ArrayList<String>().stream();
        // 通过 Arrays 中的静态方法 stream() 获取数组流
        Stream<Student> stream_02 = Arrays.stream(new Student[10]);
        // 通过 stream 类中的静态方法 of()
        Stream<String> stream_03 = Stream.of("a", "b", "c");
        // 创建无限流
        // 迭代
        Stream.iterate(0, x -> x + 2).limit(10).forEach(System.out::println);
        // 生成
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
    }

}
