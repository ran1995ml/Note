package com.ran.designpattern.adapter;

/**
 * WildTurkey
 *
 * @author rwei
 * @since 2023/6/18 21:14
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
