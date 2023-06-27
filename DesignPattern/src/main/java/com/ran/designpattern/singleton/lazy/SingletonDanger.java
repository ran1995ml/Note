package com.ran.designpattern.singleton.lazy;

/**
 * SingletonDanger
 * 懒汉式，非线程安全
 * @author rwei
 * @since 2023/6/16 10:45
 */
public class SingletonDanger {
    private static SingletonDanger singletonDanger;

    private SingletonDanger() {}

    public SingletonDanger getInstance() {
        if (singletonDanger == null) {
            singletonDanger = new SingletonDanger();
        }
        return singletonDanger;
    }
}
