package com.ran.javase.designpattern.decorator.coffee;

/**
 * Condiment
 * 装饰类，调料
 * @author rwei
 * @since 2023/4/2 22:18
 */
public abstract class Condiment extends Beverage {
    //所有调料要重新实现setDescription方法
    public abstract String getDescription();
}
