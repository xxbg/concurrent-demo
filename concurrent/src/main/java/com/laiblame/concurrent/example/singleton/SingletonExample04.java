package com.laiblame.concurrent.example.singleton;


import com.laiblame.concurrent.annoations.ThreadNoSafe;

/**
 * 静态工厂模式（懒汉模式）
 * 双重同步锁机制1
 */
@ThreadNoSafe
public class SingletonExample04 {

    // 私有构造函数
    private SingletonExample04(){

    }

    // 单例对象
    private static SingletonExample04 instance = null;

    // 1. memory = allocate() 分配对象的内存空间
    // 2. ctorInstance() 初始化对象
    // 3. instance = memory 设置instance指向刚分配的内存

    // jvm 和 cpu 优化,发生指令重排

    // 1. memory = allocate() 分配对象的内存空间
    // 2. instance = memory 设置instance指向刚分配的内存
    // 3. ctorInstance() 初始化对象

    // A线程执行指令重排后的第2步引用指向内存空间，但是还未执行第3初始化对象步骤时
    // B线程执行了getInstance方法第1层instance == null 判断，发现引用已经指向
    // 内存空间就直接返回给B线程，但是实例初始化还未完成，造成线程不安全。

    // 静态工厂方法
    public static  SingletonExample04 getInstance(){
        if (instance == null){
            synchronized (SingletonExample04.class){
                if (instance == null){
                    instance = new SingletonExample04();
                }
            }
        }
        return instance;
    }
}
