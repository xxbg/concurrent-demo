package com.laiblame.concurrent.example.immutable;





import com.google.common.collect.Maps;
import com.laiblame.concurrent.annoations.ThreadNoSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@ThreadNoSafe
public class ImmutableExample01 {

    private static final Integer a = 1;

    private static final String b = "2";

    private static final Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
          map.put(1,3);
          log.info("{}",map.get(1));
    }

    public void test(final Integer a){
//        a = 1;
    }
}
