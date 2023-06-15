package com.ran.designpattern.decorate;

/**
 * Mocha
 * 摩卡，装饰子类
 * @author rwei
 * @since 2023/6/15 17:41
 */
public class Mocha extends CondimentDecorator {
    //利用组合建立和被装饰类的联系
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "Mocha ";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1;
    }
}
