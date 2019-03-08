package com.laiblame.concurrent.example.publish;

import com.laiblame.concurrent.annoations.NoRecommend;
import com.laiblame.concurrent.annoations.ThreadNoSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadNoSafe
@NoRecommend
public class Escape {

    private  int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
