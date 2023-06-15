package com.ran.javase.designpattern.factory.abstractfactory;

import com.ran.javase.designpattern.factory.Cheese;
import com.ran.javase.designpattern.factory.Sauce;

/**
 * PizzaIngredientFactory
 * 该接口负责创建所有原料
 * @author rwei
 * @since 2023/4/3 17:13
 */
public interface PizzaIngredientFactory {
    public Sauce createSauce();
    
    public Cheese createCheese();
}
