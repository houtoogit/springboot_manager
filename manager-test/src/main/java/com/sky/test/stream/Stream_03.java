package com.sky.test.stream;

import com.sky.test.entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Directions 流操作 - 映射
 * @Author H
 * @Date 2021/4/4 16:55
 * @Version 1.0
 */
public class Stream_03 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a-a", "b-b", "c-c", "d-d");

        List<Student> students = Arrays.asList(
                new Student("peter", 25, "man"),
                new Student("davi", 20, "man"),
                new Student("jessie", 22, "man"),
                new Student("anne", 18, "woman"),
                new Student("kate", 23, "woman"),
                new Student("lady", 23, "woman")
        );


//        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
//        students.stream().map(student -> student.getName()).forEach(System.out::println);
        System.out.println(students.stream().map(student -> student.getName()).collect(Collectors.toList()));
        System.out.println(strings.stream().map(str -> str.toUpperCase()).collect(Collectors.toList()));
        System.out.println(strings.stream().flatMap(str -> Arrays.stream(str.split("-"))).collect(Collectors.toList()));
    }

}
