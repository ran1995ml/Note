package com.ran.javase.designpattern.strategy.duck.impl;

import com.ran.javase.designpattern.strategy.duck.FlyBehavior;

/**
 * FlyWithRocket
 * 用火箭飞
 * @author rwei
 * @since 2023/3/29 17:58
 */
public class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with rocket");
    }
}
