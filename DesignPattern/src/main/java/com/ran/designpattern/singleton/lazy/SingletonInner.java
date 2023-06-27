package com.ran.designpattern.singleton.lazy;

/**
 * SingletonInner
 * 饿汉式，内部类实现，获取实例时内部类才会装载
 * @author rwei
 * @since 2023/6/16 10:51
 */
public class SingletonInner {
    private SingletonInner() {}

    private static class Singleton{
        private static SingletonInner singletonInner = new SingletonInner();
    }

    public SingletonInner getInstance() {
        return Singleton.singletonInner;
    }
}
