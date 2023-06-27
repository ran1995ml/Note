package com.ran.designpattern.singleton.lazy;

/**
 * SingletonSafe
 * 懒汉式，双重锁校验
 * @author rwei
 * @since 2023/6/16 10:48
 */
public class SingletonSafe {
    private static SingletonSafe singletonSafe;

    private SingletonSafe() {}

    public SingletonSafe getInstance() {
        if (singletonSafe == null) {
            synchronized (SingletonSafe.class) {
                if (singletonSafe == null) {
                    singletonSafe = new SingletonSafe();
                }
            }
        }
        return singletonSafe;
    }
}
