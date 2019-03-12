package com.laiblame.concurrent.example.synccontainer;

import com.laiblame.concurrent.annoations.ThreadNoSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("all")
@Slf4j
public class VectorExample03 {
    // error
    private static void test1(List<Integer> v) {
        for (Integer i :
                v) {
            if (i.equals(3)){
                v.remove(3);
            }
        }
    }

    // error
    private static void test2(List<Integer> v) {
        Iterator<Integer> iterator = v.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if (i.equals(3)){
                v.remove(3);
            }
        }
    }

    // success
    private static void test3(List<Integer> v) {
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).equals(3)){
                v.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        test1(list);
//        test2(list);
        test3(list);
    }

}
