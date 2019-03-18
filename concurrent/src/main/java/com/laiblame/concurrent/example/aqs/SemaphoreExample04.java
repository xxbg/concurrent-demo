package com.laiblame.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
@SuppressWarnings("all")
public class SemaphoreExample04
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
                    if(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){// 5秒内获取1个许可  超过5秒获取不到就丢弃
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
