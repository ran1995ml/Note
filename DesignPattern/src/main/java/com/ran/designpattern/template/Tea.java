package com.ran.designpattern.template;

/**
 * Tea
 *
 * @author rwei
 * @since 2023/6/19 19:13
 */
public class Tea extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("brew tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("add lemon");
    }
}
