package com.laiblame.concurrent.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExample06 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {

            try {
                lock.lock();
                log.info("wait signal");
                condition.await();              // 1. 等待满足的条件,并释放锁
            } catch (InterruptedException e) {
                log.error("Exception e:{}",e);
            } finally {
                log.info("get signal");
                lock.unlock();                  // 4.2 释放锁
            }
        }).start();

        new Thread(() -> {
            lock.lock();                        // 2 其他线程获取锁
            log.info("get lock");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            condition.signalAll();             // 3 条件完成唤醒线程
            log.info("send signal ~");
            lock.unlock();                     // 4.1 释放锁
        }).start();
    }
}
