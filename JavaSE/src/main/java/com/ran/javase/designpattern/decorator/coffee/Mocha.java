package com.ran.javase.designpattern.decorator.coffee;

/**
 * Mocha
 * 摩卡，装饰类
 * @author rwei
 * @since 2023/4/2 22:24
 */
public class Mocha extends Condiment {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Mocha";
    }
}
