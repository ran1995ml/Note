package com.ran.designpattern.strategy;

/**
 * Mute
 * 不会叫
 * @author rwei
 * @since 2023/6/14 17:28
 */
public class Mute implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("can't quack");
    }
}
