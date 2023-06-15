package com.ran.designpattern.decorate;

/**
 * Main
 * 装饰器模式
 * @author rwei
 * @since 2023/6/15 17:46
 */
public class Main {
    public static void main(String[] args) {
        //一杯coffee加一份mocha
        Beverage beverage = new Coffee();
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());

        //一被coffee加两份mocha
        Beverage beverage1 = new Coffee();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription());
        System.out.println(beverage1.cost());
    }
}
