package com.ran.javase.designpattern.factory.factory;

import com.ran.javase.designpattern.factory.CheesePizza;
import com.ran.javase.designpattern.factory.ClamPizza;
import com.ran.javase.designpattern.factory.Pizza;

/**
 * NYStylePizzaStore
 * 子类实现自定义对象创建过程
 * @author rwei
 * @since 2023/4/3 16:23
 */
public class NYStylePizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else {
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
