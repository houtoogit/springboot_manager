package com.sky.test.stream;

import com.sky.test.entity.Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Directions 流操作 - 终止操作符
 * @Author H
 * @Date 2021/4/4 16:55
 * @Version 1.0
 */
public class Stream_06 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Student> students = Arrays.asList(
                new Student("peter", 25, "man", Student.Status.BUSY),
                new Student("davi", 20, "man", Student.Status.VOCATION),
                new Student("jessie", 22, "man", Student.Status.FREE),
                new Student("anne", 18, "woman", Student.Status.BUSY),
                new Student("kate", 23, "woman", Student.Status.FREE),
                new Student("lady", 23, "woman", Student.Status.VOCATION)
        );

        // 统计
        System.out.println(students.stream().collect(Collectors.counting()));
        // 求平均值
        System.out.println(students.stream().collect(Collectors.averagingInt(Student::getAge)));
        // 求和
        System.out.println(students.stream().collect(Collectors.summingInt(Student::getAge)));
        // 求最大值
        System.out.println(students.stream().collect(Collectors.maxBy(((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())))).get());
        // 求年龄的最小值
        System.out.println(students.stream().map(Student::getAge).collect(Collectors.minBy(Integer::compare)).get());
        // 聚合函数
        System.out.println(students.stream().collect(Collectors.summarizingInt(Student::getAge)).getMax());
        System.out.println(students.stream().collect(Collectors.summarizingInt(Student::getAge)).getMin());
        System.out.println(students.stream().collect(Collectors.summarizingInt(Student::getAge)).getSum());
        System.out.println(students.stream().collect(Collectors.summarizingInt(Student::getAge)).getAverage());
        System.out.println(students.stream().collect(Collectors.summarizingInt(Student::getAge)).getCount());
        // 分组
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getStatus)));
        // 字符串操作
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining("-", "【", "】")));

        System.out.println();

        // 收集
        students.stream().map(Student::getName).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        students.stream().map(Student::getName).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println();
        students.stream().map(Student::getName).collect(Collectors.toCollection(HashSet::new)).forEach(System.out::println);
        System.out.println();

        // 规约
        System.out.println(list.stream().reduce(0, (x, y) -> x + y));
        System.out.println(list.stream().reduce(Integer::sum).get());
        System.out.println(students.stream().map(Student::getAge).reduce(Integer::sum).get());

    }

}
