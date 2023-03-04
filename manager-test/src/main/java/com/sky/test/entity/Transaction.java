package com.sky.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Directions 交易类
 * @Author H
 * @Date 2021/4/8 21:48
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
