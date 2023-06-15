package com.ran.javase.designpattern.strategy.duck.impl;

import com.ran.javase.designpattern.strategy.duck.FlyBehavior;

/**
 * FlyNoWay
 * 不会飞
 * @author rwei
 * @since 2023/3/29 17:28
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
