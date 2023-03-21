package com.ran.javase.designpattern.singleton.lazy;

/**
 * Singleton
 * 懒汉式，线程安全，效率低，调用get方法时才开始创建实例
 * double check
 * @author rwei
 * @since 2023/2/22 17:58
 */
public class SingletonSafe {
    public static SingletonSafe singletonSafe;

    private SingletonSafe() {}

    public static synchronized SingletonSafe getInstance() {
        if (singletonSafe == null) {
            singletonSafe = new SingletonSafe();
        }
        return singletonSafe;
    }
}
