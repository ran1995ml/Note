package com.ran.designpattern.strategy;

/**
 * Main
 * 策略设计模式
 * @author rwei
 * @since 2023/6/14 17:41
 */
public class Main {
    public static void main(String[] args) {
        Duck duck = new RedDuck();
        duck.performFly();
        duck.performQuack();
        duck.display();
        duck.setFlyBehavior(new FlyNoWay());
        duck.performFly();
    }
}
