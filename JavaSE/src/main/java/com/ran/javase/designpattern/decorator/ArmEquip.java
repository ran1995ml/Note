package com.ran.javase.designpattern.decorator;

/**
 * ArmEquip
 *
 * @author rwei
 * @since 2023/3/13 17:44
 */
public class ArmEquip implements IEquip {
    @Override
    public int calculateAttack() {
        return 20;
    }

    @Override
    public String description() {
        return "屠龙刀";
    }
}
