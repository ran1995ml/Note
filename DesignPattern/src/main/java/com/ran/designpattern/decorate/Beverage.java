package com.ran.designpattern.decorate;

/**
 * Beverage
 * 被装饰类
 * @author rwei
 * @since 2023/6/15 15:44
 */
public abstract class Beverage {
    String description = "unknown";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
