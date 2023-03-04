package com.sky.test.lambda;

/**
 * @directions 测试接口
 * @Author H
 * @Date 2021/3/30 22:08
 * @Version 1.0
 */
@FunctionalInterface
public interface MyLambda<T> {

    Integer getNum(T t);

}
