package com.laiblame.concurrent.example.synccontainer;

import com.laiblame.concurrent.annoations.ThreadNoSafe;
import com.laiblame.concurrent.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@SuppressWarnings("all")
@ThreadNoSafe
@Slf4j
public class VectorExample02 {

    public static List<Integer> list = new Vector<>();

    public static void main(String[] args) {
        while (true){

            for (int i = 0; i < 10; i++) {
                list.add(i);
            }

            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        list.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }
    }

}
