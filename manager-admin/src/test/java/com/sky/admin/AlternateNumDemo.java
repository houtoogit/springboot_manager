package com.sky.admin;

/**
 * @Author: H
 * @Date: 2021/3/6 15:40
 * @Version: 1.0.0
 */
class AlternateNumDemo {

    private static  Object object=new Object();

    private static int count=0;

    private static final int i = 2;

    public static void main(String[] args) {
        for (int i = 0, j = 0; (i == 0) && (i > 8); i++) {
            j++;
            System.out.println("1111");
        }
//        new Thread(() -> {
//            while (count<100){
//                synchronized (object){
//                    //打印偶数
//                    if ((count&1)==0){
//                        System.out.println(Thread.currentThread().getName()+"--打印偶数-"+count);
//                        count++;
//                    }
//                }
//
//            }
//        }).start();
//        new Thread(() -> {
//            while (count<100){
//                synchronized (object){
//                    if ((count&1)==1){
//                        System.out.println(Thread.currentThread().getName()+"--打印奇数-"+count);
//                        count++;
//                    }
//                }
//
//            }
//        }).start();
    }
}
