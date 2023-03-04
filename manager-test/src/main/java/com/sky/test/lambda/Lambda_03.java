package com.sky.test.lambda;

import com.sky.test.entity.Student;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Directions lambda表达式学习 方法引用
 * @Author H
 * @Date 2021/4/1 22:41
 * @Version 1.0
 */
public class Lambda_03 {

    public static void main(String[] args) {

        // 构造器引用
        Supplier<Student> supplier = () -> new Student();
        Supplier<Student> supplier1 = Student::new;

        // 类::静态方法名
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator1 = Integer::compare;

        // 类::实例方法名
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        BiPredicate<String, String> biPredicate1 = String::equals;

        // 对象::实例方法名
        Consumer<String> consumer = System.out::println;
        consumer.accept("hou too is cool");

    }

}
