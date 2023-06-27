package com.ran.designpattern.factory.abstractfactory;

import com.ran.designpattern.factory.Cheese;
import com.ran.designpattern.factory.Pizza;

/**
 * Factory
 *
 * @author rwei
 * @since 2023/6/15 22:43
 */
public interface Factory {
    public Pizza createPizza();

    public Cheese createCheese();
}
