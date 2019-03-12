package com.laiblame.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@SuppressWarnings("all")
public class CountDownLatchExample02
{

    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount ; i++) {
            final int threadNum = i;
            service.execute(()->{
                try {
                    test(threadNum);
                }catch (Exception e){
                    log.info("Exception:{}",e);
                } finally {
                    countDownLatch.countDown();
                }
            });

            
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finish");
        service.shutdown();
    }

    public static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}",threadNum);
    }
}
