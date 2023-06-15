package com.ran.designpattern.decorate;

/**
 * CondimentDecorator
 * 装饰类，继承被装饰类达到类型匹配
 * @author rwei
 * @since 2023/6/15 17:32
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
