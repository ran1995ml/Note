package com.ran.javase.designpattern.strategy.duck;

import com.ran.javase.designpattern.strategy.duck.impl.FlyNoWay;
import com.ran.javase.designpattern.strategy.duck.impl.MuteQuack;

/**
 * ModelDuck
 * 模型鸭，不会飞，不会叫
 * @author rwei
 * @since 2023/3/29 17:53
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("model duck");
    }
}
