package com.laiblame.concurrent.example.commonunsafe;

import com.laiblame.concurrent.annoations.ThreadNoSafe;
import com.laiblame.concurrent.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@SuppressWarnings("all")
@ThreadSafe
@Slf4j
public class DateFormatExample02 {


    public static int  clientTotal = 5000;

    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

    }

    public static void add(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            sdf.parse("20190302");
        } catch (ParseException e) {
            log.error("parse exception:{}",e);
        }
    }
}
