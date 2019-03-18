package com.laiblame.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@SuppressWarnings("all")
public class SemaphoreExample03
{

    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount ; i++) {
            final int threadNum = i;
            service.execute(() -> {
                try {
                    if(semaphore.tryAcquire()){// 获取1个许可  如果获取不到就丢弃
                        test(threadNum);
                        semaphore.release( ); // 释放1个许可
                    }

                }catch (Exception e){
                    log.info("Exception:{}",e);
                } finally {
                    countDownLatch.countDown();
                }
            });

            
        }
        countDownLatch.await();
        log.info("finish");
        service.shutdown();
    }

    public static void test(int threadNum) throws Exception {

        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
