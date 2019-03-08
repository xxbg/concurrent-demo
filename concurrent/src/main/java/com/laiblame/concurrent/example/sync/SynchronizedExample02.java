package com.laiblame.concurrent.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SuppressWarnings("all")
public class SynchronizedExample02 {

    // 修饰一个代码块
    public static void test1(int j) {
        synchronized (SynchronizedExample02.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}",j, i);
            }
        }
    }

    public static synchronized  void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample02 example01 = new SynchronizedExample02();
        SynchronizedExample02 example02 = new SynchronizedExample02();
        ExecutorService executorService = Executors.newCachedThreadPool();

        /*executorService.execute(() -> {
            example01.test1();
        });

        executorService.execute(() -> {
            example01.test1();
        });*/

        /*executorService.execute(() -> {
            example01.test2();
        });

        executorService.execute(() -> {
            example01.test2();
        });*/


        executorService.execute(() -> {
            example01.test1(1);
        });

        executorService.execute(() -> {
            example02.test1(2);
        });
        /*executorService.execute(() -> {
            example01.test2(1);
        });

        executorService.execute(() -> {
            example02.test2(2);
        });*/
        executorService.shutdown();
    }
}
