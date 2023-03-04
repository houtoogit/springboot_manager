package com.sky.admin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author: H
 * @Date: 2021/3/7 22:02
 * @Version: 1.0.0
 */
public class Hash {

    private int id;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Hash hash = (Hash) o;
//        return id == hash.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Hash hash_a = new Hash();
//        System.out.println("Hash值：->" + hash_a.hashCode());
//        System.out.println("地址值：->" +hash_a);
//
//
//        Hash hash_b = new Hash();
//        System.out.println("Hash值：->" + hash_b.hashCode());
//        System.out.println("地址值：->" +hash_b);

//        ArrayList<Object> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");

//        for (Object o : list) {
//            list.set(1, "c");
//            System.out.println(o);
//        }

//        Iterator<Object> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            iterator.remove();
//            System.out.println(iterator.next());
//        }
//
//        HashSet<Object> set = new HashSet<>();



//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();

//        MyThread myThread = new MyThread();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(myThread);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        Integer integer = futureTask.get();
//        System.out.println(integer);

//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//        }).start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable runnable = new MyRunnable();
        for (int i = 0; i < 5; i++) {
            executorService.execute(runnable);
        }
        System.out.println("线程任务开始执行.....");
        executorService.shutdown();

    }

}
