package com.ran.javase.designpattern.strategy.duck.impl;

import com.ran.javase.designpattern.strategy.duck.QuackBehavior;

/**
 * MuteQuack
 * 不会叫
 * @author rwei
 * @since 2023/3/29 17:38
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Silence");
    }
}
