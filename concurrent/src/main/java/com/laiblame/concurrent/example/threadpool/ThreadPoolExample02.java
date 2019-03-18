package com.laiblame.concurrent.example.threadpool;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SuppressWarnings("all")
public class ThreadPoolExample02 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            service.execute(() ->{
                log.info("task:{}",index);
            });
        }

        service.shutdown();
    }
}
