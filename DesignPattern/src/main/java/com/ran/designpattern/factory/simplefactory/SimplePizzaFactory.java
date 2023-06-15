package com.ran.designpattern.factory.simplefactory;

import com.ran.designpattern.factory.CheesePizza;
import com.ran.designpattern.factory.ClamPizza;
import com.ran.designpattern.factory.Pizza;

/**
 * SimplePizzaFactory
 * 简单工厂模式
 * @author rwei
 * @since 2023/6/15 21:57
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
