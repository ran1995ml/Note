package com.ran.designpattern.template;

/**
 * Coffee
 *
 * @author rwei
 * @since 2023/6/19 19:14
 */
public class Coffee extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("brew coffee");
    }

    @Override
    public void addCondiments() {
        System.out.println("add milk");
    }
}
