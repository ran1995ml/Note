package com.ran.javase.designpattern.factory.factory;

import com.ran.javase.designpattern.factory.Pizza;

/**
 * PizzaStore
 * 工厂模式，不同的使用方对工厂的创建有不同的需求，将工厂的创建过程交给子类实现
 * @author rwei
 * @since 2023/4/3 16:11
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        //对象创建交给子类，抽象类并不知道谁参与进来
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    
    public abstract Pizza createPizza(String type);
}
