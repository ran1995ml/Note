package com.ran.designpattern.decorate;

/**
 * Coffee
 * 被装饰子类
 * @author rwei
 * @since 2023/6/15 17:36
 */
public class Coffee extends Beverage {
    @Override
    public String getDescription() {
        return "coffee ";
    }

    @Override
    public double cost() {
        return 10.0;
    }
}
