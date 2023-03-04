package com.sky.test.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Directions lambda 表达式学习
 * @Author H
 * @Date 2021/3/30 22:13
 * @Version 1.0
 */
@Slf4j
public class Lambda_02 {

    public static Integer operation(Integer num, MyLambda<Integer> myLambda) {
           return myLambda.getNum(num);
    }

    public static void main(String[] args) {

        System.out.println(operation(5, x -> x * x));

        MyLambda<Integer> myLambda = x -> x - x;
        System.out.println(myLambda.getNum(10));

        new Runnable() {
            @Override
            public void run() {
                System.out.println("hou too is cool");
            }
        }.run();

        Runnable runnable = () -> System.out.println("hou tao is cool");
        runnable.run();

        System.out.println("-----------------------------------");

        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("too");

        System.out.println("-----------------------------------");

        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("hou - too");
            return Integer.compare(x, y);
        };

        System.out.println("-----------------------------------");

        Comparator<Integer> comparator_1 = (x, y) -> Integer.compare(x, y);
    }

}
