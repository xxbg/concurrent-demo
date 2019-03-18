package com.laiblame.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@SuppressWarnings("all")
public class CyclicBarrierExample02 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    private static final Integer threadNum = 10;

    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < threadNum; i++) {
            final Integer thread = i;
            Thread.sleep(1000);
            service.execute(() -> {
                try {
                    race(thread);
                } catch (Exception e) {
                    log.error("Exception e:{}",e);
                }
            });
        }
        
        service.shutdown();
    }

    private static void race(Integer threadNum) throws Exception {
            Thread.sleep(1000);
            log.info("{} is ready",threadNum);
            try {
                cyclicBarrier.await(1800, TimeUnit.MILLISECONDS);
            } catch (Exception e){
                log.warn("Exception e:{}",e);
            }

            log.info("{} is continue",threadNum);
    }
}
