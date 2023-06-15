package com.ran.designpattern.strategy;

/**
 * Duck
 *
 * @author rwei
 * @since 2023/6/14 17:36
 */
public abstract class Duck {
    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    //动态调整行为
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
