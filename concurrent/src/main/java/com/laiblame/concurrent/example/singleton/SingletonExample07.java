package com.laiblame.concurrent.example.singleton;



import com.laiblame.concurrent.annoations.Recommend;
import com.laiblame.concurrent.annoations.ThreadSafe;

/**
 * 枚举模式（最安全的）
 */
@ThreadSafe
@Recommend
public class SingletonExample07 {

    // 私有构造函数
    private SingletonExample07(){

    }

    public static SingletonExample07 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample07 instance;

        Singleton(){
            instance = new SingletonExample07();
        }

        public SingletonExample07 getInstance(){
            return instance;
        }
    }
}
