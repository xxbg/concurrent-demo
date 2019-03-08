package com.laiblame.concurrent.example.atomic;

import com.laiblame.concurrent.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
@SuppressWarnings("all")
public class AtomicExample05 {

    private static AtomicIntegerFieldUpdater<AtomicExample05> updater =  AtomicIntegerFieldUpdater.newUpdater(AtomicExample05.class,"count");

    @Getter
    private volatile int count = 100;

    private static final AtomicExample05 example05 = new AtomicExample05();

    public static void main(String[] args) {

        if (updater.compareAndSet(example05,100,120)){
            log.info("update success1 , {}",example05.getCount());
        }

        if (updater.compareAndSet(example05,100,120)){
            log.info("update success2 , {}",example05.getCount());
        } else {
            log.info("update fail , {}",example05.getCount());
        }
    }
}
