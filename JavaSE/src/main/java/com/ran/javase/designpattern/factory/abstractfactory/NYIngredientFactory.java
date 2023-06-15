package com.ran.javase.designpattern.factory.abstractfactory;

import com.ran.javase.designpattern.factory.Cheese;
import com.ran.javase.designpattern.factory.Sauce;

/**
 * NYIngredientFactory
 *
 * @author rwei
 * @since 2023/4/3 17:17
 */
public class NYIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Sauce createSauce() {
        return new Sauce("NY sauce");
    }

    @Override
    public Cheese createCheese() {
        return new Cheese("NY cheese");
    }
}
