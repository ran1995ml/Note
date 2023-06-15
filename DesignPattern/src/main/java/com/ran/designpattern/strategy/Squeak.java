package com.ran.designpattern.strategy;

/**
 * Squeak
 * 吱吱叫
 * @author rwei
 * @since 2023/6/14 17:27
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak");
    }
}
