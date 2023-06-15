package com.ran.javase.designpattern.decorator.coffee;

/**
 * Espresso
 * 浓缩咖啡
 * @author rwei
 * @since 2023/4/2 22:21
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
