package com.ran.javase.designpattern.factory.abstractfactory;


/**
 * PizzaStore
 *
 * @author rwei
 * @since 2023/4/3 17:32
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
