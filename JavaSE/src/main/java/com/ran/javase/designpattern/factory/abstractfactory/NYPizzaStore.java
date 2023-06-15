package com.ran.javase.designpattern.factory.abstractfactory;

/**
 * NYPizzaStore
 * 不同地区的店采用不同的原料厂，将原料厂抽象为工厂
 * @author rwei
 * @since 2023/4/3 17:28
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory factory = new NYIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new CheesePizza(factory);
        }
        return pizza;
    }
}
