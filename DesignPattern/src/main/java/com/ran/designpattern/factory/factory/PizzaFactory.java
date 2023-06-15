package com.ran.designpattern.factory.factory;

import com.ran.designpattern.factory.Pizza;

/**
 * PizzaFactory
 * 工厂模式，类的创建过程推迟到子类
 * @author rwei
 * @since 2023/6/15 22:07
 */
public abstract class PizzaFactory {
    public Pizza createPizza(String type) {
        //创建对象交给子类，其他类都可以使用到子类创建的对象
        Pizza pizza = generatePizza(type);
        System.out.println(pizza.getType());
        return pizza;
    }

    public abstract Pizza generatePizza(String type);
}
