package com.ran.designpattern.factory;

import com.ran.designpattern.factory.abstractfactory.Factory;
import com.ran.designpattern.factory.abstractfactory.PizzaSourceFactory;
import com.ran.designpattern.factory.factory.ChinaPizzaFactory;
import com.ran.designpattern.factory.factory.PizzaFactory;
import com.ran.designpattern.factory.simplefactory.SimplePizzaFactory;

/**
 * Main
 *
 * @author rwei
 * @since 2023/6/15 22:02
 */
public class Main {
    public static void main(String[] args) {
        //简单工厂模式
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        Pizza pizza = simplePizzaFactory.createPizza("cheese");

        //工厂模式
        PizzaFactory pizzaFactory = new ChinaPizzaFactory();
        Pizza pizza1 = pizzaFactory.createPizza("cheese");

        //抽象工厂模式
        Factory factory = new PizzaSourceFactory();
        Pizza pizza2 = factory.createPizza();
        Cheese cheese = factory.createCheese();
    }
}
