package com.ran.javase.designpattern.strategy.duck;

/**
 * Duck
 * 模拟鸭子游戏，会出现各种鸭子，设计一个鸭子超类Duck
 * @author rwei
 * @since 2023/3/29 17:19
 */
public abstract class Duck {
    public FlyBehavior flyBehavior;

    public QuackBehavior quackBehavior;

    public Duck() {

    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks can swim");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
