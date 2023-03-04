package com.sky.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Directions lambda表达式学习 -- 内置四大核心的函数式借口
 * @Author H
 * @Date 2021/4/1 21:54
 * @Version 1.0
 */
public class Lambda_01 {

    public static void main(String[] args) {

        happy(100, m -> System.out.println("brother like girl: " + m * m));
        System.out.println(Arrays.toString(getList(10, () -> (int) (Math.random() * 100)).toArray()));
        System.out.println(str("\t\t\t  houtoo is cool   ", str -> str.trim()));
        System.out.println(str("hou-too", str -> str.substring(2, 5)));
        System.out.println(Arrays.toString(filter(Arrays.asList("hou", "too", "is", "cool"), str -> str.length() > 2).toArray()));;

    }

    // Predicate<T> 断言型接口
    public static List<String> filter(List<String> list, Predicate<String> predicate) {
        ArrayList<String> strings = new ArrayList<>();
        for (String string : list) {
            if (predicate.test(string)) {
                strings.add(string);
            }
        }
        return strings;
    }

    // Consumer<T> 消费型接口
    public static void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    // Supplier<T> 供给型接口
    public static List<Integer> getList(int num, Supplier<Integer> supplier) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    // Function<T> 函数型接口　
    public static String str(String string, Function<String, String> function) {
        return function.apply(string);
    }

}
