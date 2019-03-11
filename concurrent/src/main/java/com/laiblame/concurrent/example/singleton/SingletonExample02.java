package com.laiblame.concurrent.example.singleton;



import com.laiblame.concurrent.annoations.ThreadSafe;

/**
 * 静态工厂模式（饿汉模式）
 * 类加载就实例化（不使用实例，可能会造成资源浪费）
 */
@ThreadSafe
public class SingletonExample02 {

    // 私有构造函数
    private SingletonExample02(){

    }

    // 单例对象
    private static SingletonExample02 instance = new SingletonExample02();

    // 静态工厂方法
    public static SingletonExample02 getInstance(){
        return instance;
    }
}
