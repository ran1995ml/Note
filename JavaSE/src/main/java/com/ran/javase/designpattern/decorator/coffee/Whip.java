package com.ran.javase.designpattern.decorator.coffee;

/**
 * Whip
 *
 * @author rwei
 * @since 2023/4/2 22:27
 */
public class Whip extends Condiment {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Whip";
    }
}
