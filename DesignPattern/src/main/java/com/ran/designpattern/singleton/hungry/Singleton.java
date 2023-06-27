package com.ran.designpattern.singleton.hungry;

/**
 * Singleton
 * 单例设计模式，饿汉式
 * @author rwei
 * @since 2023/6/16 10:34
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){}

    public Singleton getInstance() {
        return singleton;
    }
}
