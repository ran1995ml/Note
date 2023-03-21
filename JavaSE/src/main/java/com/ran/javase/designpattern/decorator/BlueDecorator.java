package com.ran.javase.designpattern.decorator;

/**
 * BlueDecorator
 *
 * @author rwei
 * @since 2023/3/13 17:47
 */
public class BlueDecorator implements DecoratorIEquip {
    private IEquip iEquip;

    public BlueDecorator(IEquip iEquip) {
        this.iEquip = iEquip;
    }

    @Override
    public int calculateAttack() {
        return this.iEquip.calculateAttack() + 7;
    }

    @Override
    public String description() {
        return this.iEquip.description() + "蓝宝石";
    }
}
