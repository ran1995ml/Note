package com.ran.javase.designpattern.strategy.duck.impl;

import com.ran.javase.designpattern.strategy.duck.QuackBehavior;

/**
 * Quack
 * 会叫
 * @author rwei
 * @since 2023/3/29 17:31
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
