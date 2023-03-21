package com.ran.javase.designpattern.decorator;

/**
 * ShoeEquip
 *
 * @author rwei
 * @since 2023/3/13 17:45
 */
public class ShoeEquip implements IEquip {

    @Override
    public int calculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "攻速鞋";
    }
}
