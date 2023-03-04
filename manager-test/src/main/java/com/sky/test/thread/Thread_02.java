package com.sky.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @Directions 多线程删除文件不彻底测试
 * @Author H
 * @Date 2021/4/28 21:03
 * @Version 1.0
 */
@Slf4j
public class Thread_02 {

    public static void main(String[] args) throws Exception {
        File src = new File("/Users/hou-too/Desktop/install");
        File tar = new File("/Users/hou-too/Desktop/target");
        System.out.println(Thread.currentThread().getName());
        new Thread(() -> deleteFile(src)).start();
//        deleteFile(src);
    }

    public static void deleteFile(File file) {
        System.out.println(Thread.currentThread().getName());
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFile(f);
                }
                f.delete();
            }
        }
        file.delete();
    }


    public static void copyFile(File src, File tar) {
        try (FileInputStream inputStream = new FileInputStream(src);
             FileOutputStream outputStream = new FileOutputStream(tar);
             FileChannel inputChannel = inputStream.getChannel();
             FileChannel outputChannel = outputStream.getChannel()) {
            inputChannel.transferTo(0, inputChannel.size(), outputChannel);
        } catch (Exception exception) {
            log.info(exception.getMessage());
        }
    }

}
