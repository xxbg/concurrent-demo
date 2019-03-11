package com.laiblame.concurrent.example.singleton;


import com.laiblame.concurrent.annoations.ThreadNoSafe;

/**
 * 静态工厂模式（懒汉模式）
 */
@ThreadNoSafe
public class SingletonExample01 {

    // 私有构造函数
    private SingletonExample01(){

    }

    // 单例对象
    private static SingletonExample01 instance = null;

    // 静态工厂方法
    public static SingletonExample01 getInstance(){
        if (instance == null){
            instance = new SingletonExample01();
        }
        return instance;
    }
}
