package com.ran.javase.designpattern.strategy.duck;

import com.ran.javase.designpattern.strategy.duck.Duck;
import com.ran.javase.designpattern.strategy.duck.impl.FlyWithWings;
import com.ran.javase.designpattern.strategy.duck.impl.Quack;

/**
 * GreenDuck
 * 绿鸭子，会飞，会叫
 * @author rwei
 * @since 2023/3/29 17:48
 */
public class GreenDuck extends Duck {

    public GreenDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("green duck");
    }
}
