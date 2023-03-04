package com.sky.test.stream;

import lombok.AllArgsConstructor;

import java.util.concurrent.RecursiveTask;

/**
 * @Directions Fork Join
 * @Author H
 * @Date 2021/4/10 10:25
 * @Version 1.0
 */
@AllArgsConstructor
public class ForkJoinCalculate extends RecursiveTask {

    private static final long serialVersionUID = 1183542617162505467L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000L;

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            left.fork();
            right.fork();
            return (long)left.join() + (long)right.join();
        }
    }
}
