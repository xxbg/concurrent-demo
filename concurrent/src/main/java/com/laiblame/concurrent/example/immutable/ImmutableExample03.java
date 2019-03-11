package com.laiblame.concurrent.example.immutable;





import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.laiblame.concurrent.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample03 {

     private static final ImmutableList<Integer> list = ImmutableList.of(1,2,3);

     private static final ImmutableSet<Integer> set = ImmutableSet.copyOf(list);

     private static final ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,3,4);

     private static final ImmutableMap<Integer,Integer> map2 = ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).put(5,6).build();

     public static void main(String[] args) {
        map2.put(3,5);
    }


}
