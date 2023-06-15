package com.ran.javase.designpattern.strategy.duck.impl;

import com.ran.javase.designpattern.strategy.duck.FlyBehavior;

/**
 * FlyWithWings
 * 会飞
 * @author rwei
 * @since 2023/3/29 17:27
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
