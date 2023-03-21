package com.ran.javase.designpattern.decorator;

/**
 * RedDecorator
 *
 * @author rwei
 * @since 2023/3/13 17:47
 */
public class RedDecorator implements DecoratorIEquip {
    private IEquip iEquip;

    public RedDecorator(IEquip iEquip) {
        this.iEquip = iEquip;
    }

    @Override
    public int calculateAttack() {
        return this.iEquip.calculateAttack() + 5;
    }

    @Override
    public String description() {
        return this.iEquip.description() + "红宝石";
    }
}
