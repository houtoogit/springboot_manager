package com.sky.test.optional;

import com.sky.test.entity.Student;

import java.util.Optional;

/**
 * @Directions optional类
 * @Author H
 * @Date 2021/4/11 13:35
 * @Version 1.0
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<Student> optional = Optional.of(new Student());
        System.out.println(optional.get());
        Optional<Student> empty = Optional.empty();
        System.out.println(empty.get());
        Optional<Object> o = Optional.ofNullable(new Student());
        System.out.println(o.get());
        if (o.isPresent()) {
            System.out.println(o.get());
        }
    }

}
