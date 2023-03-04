package com.sky.test.stream;

import com.sky.test.entity.Student;

import java.util.Arrays;
import java.util.List;

/**
 * @Directions 流操作 - 筛选与切片
 * @Author H
 * @Date 2021/4/4 16:15
 * @Version 1.0
 */
public class Stream_02 {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("peter", 25, "man"),
                new Student("davi", 20, "man"),
                new Student("jessie", 22, "man"),
                new Student("anne", 18, "woman"),
                new Student("kate", 23, "woman"),
                new Student("lady", 23, "woman")
        );

        // 过滤
        students.stream().filter(student -> student.getAge() > 20).forEach(System.out::println);
        // limit skip
        students.stream().filter(student -> student.getAge() > 20).limit(1).forEach(System.out::println);
        // 去重
        students.stream().filter(student -> student.getAge() > 20).distinct().forEach(System.out::println);

    }

}
