package com.laiblame.concurrent.example.deadlock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLock implements Runnable {

    public int flag = 1;

    private static final Object o1 = new Object() , o2 = new Object();

    @Override
    public void run() {
        log.info("flag:{}",flag);
        if ( 1 == flag){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    log.info("1");
                }
            }
        }
        if ( 0 == flag){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    log.info("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock dl1 = new DeadLock();
        DeadLock dl2 = new DeadLock();
        dl1.flag = 1;
        dl2.flag = 0;

        new Thread(dl1).start();
        new Thread(dl2).start();
    }
}
