package com.laiblame.concurrent.example.singleton;


import com.laiblame.concurrent.annoations.NoRecommend;
import com.laiblame.concurrent.annoations.ThreadSafe;

/**
 * 静态工厂模式（懒汉模式）
 */
@ThreadSafe
@NoRecommend
public class SingletonExample03 {

    // 私有构造函数
    private SingletonExample03(){

    }

    // 单例对象
    private static SingletonExample03 instance = null;

    // 静态工厂方法
    public static synchronized SingletonExample03 getInstance(){
        if (instance == null){
            instance = new SingletonExample03();
        }
        return instance;
    }
}
