package com.ran.javase.designpattern.singleton.hungry;

/**
 * Singleton
 * 单例设计模式饿汉式
 * @author rwei
 * @since 2023/2/22 17:56
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){}

    public Singleton getSingleton() {
        return singleton;
    }
}
