package com.laiblame.concurrent.example.singleton;


import com.laiblame.concurrent.annoations.ThreadSafe;

/**
 * 静态工厂模式（懒汉模式）
 * 双重同步锁机制2
 */
@ThreadSafe
public class SingletonExample05 {

    // 私有构造函数
    private SingletonExample05(){

    }

    // 单例对象
    private volatile static SingletonExample05 instance = null; // volatile + 双重检测机制 防止指令重排导致的线程不安全

    // 静态工厂方法
    public static SingletonExample05 getInstance(){
        if (instance == null){
            synchronized (SingletonExample05.class){
                if (instance == null){
                    instance = new SingletonExample05();
                }
            }
        }
        return instance;
    }
}
