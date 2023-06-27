package com.ran.designpattern.adapter;

/**
 * MallardDuck
 *
 * @author rwei
 * @since 2023/6/18 21:13
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
