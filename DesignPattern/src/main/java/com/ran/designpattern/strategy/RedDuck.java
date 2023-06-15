package com.ran.designpattern.strategy;

/**
 * RedDuck
 * Duck的实现类
 * @author rwei
 * @since 2023/6/14 17:39
 */
public class RedDuck extends Duck {


    public RedDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Mute();
    }

    @Override
    public void display() {
        System.out.println("red duck");
    }
}
