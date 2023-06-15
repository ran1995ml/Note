package com.ran.javase.designpattern.decorator.coffee;

/**
 * TestCoffee
 *
 * @author rwei
 * @since 2023/4/2 22:29
 */
public class TestCoffee {
    public static void main(String[] args) {
        //Espresso咖啡，加2份Mocha，1份Whip
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription() + " " + beverage.cost());
    }
}
