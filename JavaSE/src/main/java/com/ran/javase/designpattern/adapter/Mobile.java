package com.ran.javase.designpattern.adapter;

/**
 * Mobile
 *
 * @author rwei
 * @since 2023/3/10 17:38
 */
public class Mobile {
    public void inputPower(V5Power v5Power) {
        int power = v5Power.provideV5Power();
        System.out.println("input power: " + power);
    }
}
