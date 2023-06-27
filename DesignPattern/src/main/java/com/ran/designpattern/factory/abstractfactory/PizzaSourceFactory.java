package com.ran.designpattern.factory.abstractfactory;

import com.ran.designpattern.factory.Cheese;
import com.ran.designpattern.factory.ClamPizza;
import com.ran.designpattern.factory.Pizza;
import com.ran.designpattern.factory.RedCheese;

/**
 * PizzaFactory
 *
 * @author rwei
 * @since 2023/6/15 22:44
 */
public class PizzaSourceFactory implements Factory {

    @Override
    public Pizza createPizza() {
        return new ClamPizza();
    }

    @Override
    public Cheese createCheese() {
        return new RedCheese();
    }
}
