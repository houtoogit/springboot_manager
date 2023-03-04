package com.sky.admin;

import com.sky.admin.entity.AdminInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: H
 * @Date: 2021/3/6 17:53
 * @Version: 1.0.0
 */
public class SuperClass {

    public SuperClass() {
        System.out.println("A/n");
    }

    public SuperClass(int i) {
        this();
        System.out.println("AA/n");
    }

    public static void main(String[] args) {
//        new SuperClass(0);  // A/n AA/n
//        new SubClass(); // A/n B/n
//        new SubClass(1); //  A/n BB/n

//        int j = 0;
//        for (int i = 0; i < 1000; i++) {
//            j = j++;
//            System.out.println(j);
//        }
//        System.out.println(j);


//        int[] array = new int[5];
//
//        for (int i = 0; i < array.length; i++) {
//            array[1] = 2;
//        }

//        System.out.println(10 + '涛');


    }


}
