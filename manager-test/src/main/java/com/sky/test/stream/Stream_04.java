package com.sky.test.stream;

import com.sky.test.entity.Student;

import java.util.Arrays;
import java.util.List;

/**
 * @Directions 流操作 - 排序
 * @Author H
 * @Date 2021/4/4 16:55
 * @Version 1.0
 */
public class Stream_04 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("eee", "ddd", "ccc", "aaa");

        List<Student> students = Arrays.asList(
                new Student("peter", 25, "man"),
                new Student("davi", 20, "man"),
                new Student("jessie", 22, "man"),
                new Student("anne", 18, "woman"),
                new Student("kate", 23, "woman"),
                new Student("lady", 23, "woman")
        );

        strings.stream().sorted().forEach(System.out::println);
        students.stream().sorted((o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return - o1.getAge().compareTo(o2.getAge());
            }
        }).forEach(System.out::println);

    }

}
