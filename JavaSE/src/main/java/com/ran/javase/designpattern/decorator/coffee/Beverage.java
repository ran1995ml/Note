package com.ran.javase.designpattern.decorator.coffee;

/**
 * Beverage
 * 咖啡的基类
 * @author rwei
 * @since 2023/4/2 22:16
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
