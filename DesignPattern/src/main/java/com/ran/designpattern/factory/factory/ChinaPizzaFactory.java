package com.ran.designpattern.factory.factory;

import com.ran.designpattern.factory.CheesePizza;
import com.ran.designpattern.factory.ClamPizza;
import com.ran.designpattern.factory.Pizza;

/**
 * ChinaPizzaFactory
 *
 * @author rwei
 * @since 2023/6/15 22:11
 */
public class ChinaPizzaFactory extends PizzaFactory {
    @Override
    public Pizza generatePizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
