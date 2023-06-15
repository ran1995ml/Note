package com.ran.designpattern.strategy;

/**
 * FlyWithWings
 * 会飞
 * @author rwei
 * @since 2023/6/14 17:25
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with wings");
    }
}
