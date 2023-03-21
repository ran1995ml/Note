package com.ran.javase.designpattern.singleton.lazy;

/**
 * SingletonInner
 * 懒汉式，内部类实现，获取实例时内部类才会装载
 * 静态成员在类首次加载时初始化，且别的线程无法进入
 * @author rwei
 * @since 2023/2/25 22:32
 */
public class SingletonInner {
    private SingletonInner() {}

    private static class SingletonHolder{
        private static SingletonInner instance = new SingletonInner();
    }

    public static SingletonInner getInstance() {
        return SingletonHolder.instance;
    }
}
