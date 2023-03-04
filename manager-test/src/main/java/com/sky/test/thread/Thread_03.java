package com.sky.test.thread;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Directions 练习多线程同步下载图片
 * @Author H
 * @Date 2021/5/22 09:59
 * @Version 1.0
 */
@Slf4j
public class Thread_03 extends Thread {

    private String url;
    private String name;

    public Thread_03(String name, String url) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownload download = new WebDownload();
        download.downloadImg(url, name);
        log.info("下载了名字叫：{}的网络图片", name);
    }

    public static void main(String[] args) {
        Thread_03 thread_01 = new Thread_03("001.jpg", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fpic%2Ff%2F45%2F1f2e706887.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624243438&t=1d91488e17daa18af13ac26b48e27b67");
        Thread_03 thread_02 = new Thread_03("002.jpg", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fpic%2Ff%2F45%2F1f2e706887.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624243438&t=1d91488e17daa18af13ac26b48e27b67");
        Thread_03 thread_03 = new Thread_03("003.jpg", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fpic%2Ff%2F45%2F1f2e706887.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624243438&t=1d91488e17daa18af13ac26b48e27b67");
        thread_01.start();
        thread_02.start();
        thread_03.start();
    }
}

/**
 * 图片下载器
 */
@Slf4j
class WebDownload {
    public void downloadImg(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            log.warn("download error: {}", e.getMessage());
        }
    }
}