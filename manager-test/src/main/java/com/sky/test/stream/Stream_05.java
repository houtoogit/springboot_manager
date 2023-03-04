package com.sky.test.stream;

import com.sky.test.entity.Student;

import java.util.Arrays;
import java.util.List;

/**
 * @Directions 流操作 - 终止操作符
 * @Author H
 * @Date 2021/4/4 16:55
 * @Version 1.0
 */
public class Stream_05 {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("peter", 25, "man", Student.Status.BUSY),
                new Student("davi", 20, "man", Student.Status.VOCATION),
                new Student("jessie", 22, "man", Student.Status.FREE),
                new Student("anne", 18, "woman", Student.Status.BUSY),
                new Student("kate", 23, "woman", Student.Status.FREE),
                new Student("lady", 23, "woman", Student.Status.VOCATION)
        );

        // allMatch
        System.out.println(students.stream().allMatch(student -> student.getStatus().equals(Student.Status.BUSY)));
        // anyMatch
        System.out.println(students.stream().anyMatch(student -> student.getAge() == 25));
        // noneMatch
        System.out.println(students.stream().noneMatch(student -> student.getName().equals(Student.Status.VOCATION)));
        // findMatch
        System.out.println(students.stream().sorted((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())).findFirst().get());
        // findAny
        System.out.println(students.stream().findAny().get());
        // count
        System.out.println(students.stream().count());
        // max
        System.out.println(students.stream().max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())).get());
        System.out.println(students.stream().map(Student::getAge).max(Integer::compare).get());
        // min
        System.out.println(students.stream().min((o1, o2) -> -o1.getName().compareTo(o2.getName())).get());
        System.out.println(students.stream().map(Student::getAge).min(Integer::compare).get());
    }

}
