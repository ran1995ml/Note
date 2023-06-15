package com.ran.javase.designpattern.factory.simplefactory;

import com.ran.javase.designpattern.factory.CheesePizza;
import com.ran.javase.designpattern.factory.ClamPizza;
import com.ran.javase.designpattern.factory.Pizza;
import com.ran.javase.designpattern.factory.VeggiePizza;

/**
 * SimplePizzaFactory
 * 简单工厂模式
 * @author rwei
 * @since 2023/4/3 15:14
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
