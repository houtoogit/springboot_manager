package com.sky.test.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * @Directions
 * @Author H
 * @Date 2021/4/1 23:10
 * @Version 1.0
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Student {

    private String name;
    private Integer age;
    private String sex;
    private Status status;

    public Student(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Student(String name, Integer age, String sex, Status status) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.status = status;
    }

    public enum Status {
        FREE,
        BUSY,
        VOCATION
    }

}
