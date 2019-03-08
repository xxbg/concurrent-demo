package com.laiblame.concurrent.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample01 {

    // 修饰一个代码块
    public void test1(int j) {
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}",j, i);
            }
        }
    }

    public synchronized  void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample01 example01 = new SynchronizedExample01();
        SynchronizedExample01 example02 = new SynchronizedExample01();
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


       /* executorService.execute(() -> {
            example01.test1(1);
        });

        executorService.execute(() -> {
            example02.test1(2);
        });
        */
        executorService.execute(() -> {
            example01.test2(1);
        });

        executorService.execute(() -> {
            example02.test2(2);
        });
        executorService.shutdown();
    }
}
