package com.ran.javase.designpattern.singleton.lazy;

/**
 * SingleDanger
 * 懒汉式，双重校验，线程安全
 * @author rwei
 * @since 2023/2/22 18:00
 */
public class SingleDanger {
    public static SingleDanger singleDanger;

    private SingleDanger() {}

    public static SingleDanger getInstance() {
        if (singleDanger == null) {
            synchronized (SingleDanger.class) {
                if (singleDanger == null) {
                    singleDanger = new SingleDanger();
                }
            }
        }
        return singleDanger;
    }
}
