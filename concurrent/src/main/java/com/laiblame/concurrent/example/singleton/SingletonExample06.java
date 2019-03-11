package com.laiblame.concurrent.example.singleton;



import com.laiblame.concurrent.annoations.ThreadSafe;

/**
 * 静态工厂模式（饿汉模式）
 * 类加载就实例化（不使用实例，可能会造成资源浪费）
 * 注意:静态域要先于实例初始化的静态方法块，否则会发生静态域被重置为null的情况，报空指正异常。
 */
@ThreadSafe
public class SingletonExample06 {

    // 私有构造函数
    private SingletonExample06(){

    }

    // 单例对象
    private static SingletonExample06 instance = null; // 静态域

    static { // 静态代码块
        instance = new SingletonExample06();
    }

    // 静态工厂方法
    public static SingletonExample06 getInstance(){
        return instance;
    }
}
