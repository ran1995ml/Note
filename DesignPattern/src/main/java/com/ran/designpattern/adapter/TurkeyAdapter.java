package com.ran.designpattern.adapter;

/**
 * TurkeyAdapter
 * 适配器，将Turkey转换成Duck
 * @author rwei
 * @since 2023/6/18 21:14
 */
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
