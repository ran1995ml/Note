package com.ran.designpattern.strategy;

/**
 * FlyNoWay
 * 不会飞
 * @author rwei
 * @since 2023/6/14 17:26
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("can't fly");
    }
}
