package com.laiblame.concurrent.example.threadpool;


import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@SuppressWarnings("all")
public class ThreadPoolExample03 {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        /*for (int i = 0; i < 10; i++) {
            final int index = i;
            service.execute(() ->{
                log.info("task:{}",index);
            });
        }*/

        /*service.schedule(()->{
            log.warn("schedule run");
        },3,TimeUnit.SECONDS);*/

        /*service.scheduleAtFixedRate(()->{
            log.warn("shedule run");
        },1,3, TimeUnit.SECONDS);*/

//        service.shutdown();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5 * 1000);
    }
}
