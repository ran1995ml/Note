package com.ran.javase.designpattern.strategy;

import com.ran.javase.designpattern.strategy.duck.Duck;
import com.ran.javase.designpattern.strategy.duck.GreenDuck;
import com.ran.javase.designpattern.strategy.duck.ModelDuck;
import com.ran.javase.designpattern.strategy.duck.impl.FlyWithRocket;

/**
 * TestDuck
 *
 * @author rwei
 * @since 2023/3/29 17:54
 */
public class TestDuck {
    public static void main(String[] args) {
        Duck greenDuck = new GreenDuck();
        Duck modelDuck = new ModelDuck();
        greenDuck.performFly();
        modelDuck.performFly();
        // 模型鸭改成用火箭飞
        modelDuck.setFlyBehavior(new FlyWithRocket());
        modelDuck.performFly();
    }
}
