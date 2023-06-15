package com.ran.javase.designpattern.factory.abstractfactory;

import com.ran.javase.designpattern.factory.Cheese;
import com.ran.javase.designpattern.factory.Sauce;

/**
 * CheesePizza
 * pizza和区域原料解耦
 * @author rwei
 * @since 2023/4/3 17:24
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;
    
    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("preparing");
        Cheese cheese = pizzaIngredientFactory.createCheese();
        Sauce sauce = pizzaIngredientFactory.createSauce();
    }
}
