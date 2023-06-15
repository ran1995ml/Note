package com.ran.javase.designpattern.factory.simplefactory;

import com.ran.javase.designpattern.factory.Pizza;

/**
 * PizzaStore
 * 使用工厂创建对象
 * @author rwei
 * @since 2023/4/3 15:33
 */
public class PizzaStore {
    SimplePizzaFactory factory;
    
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }
    
    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);
        return pizza;
    }
}
