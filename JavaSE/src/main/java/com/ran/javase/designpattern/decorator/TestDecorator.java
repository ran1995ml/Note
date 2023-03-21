package com.ran.javase.designpattern.decorator;

/**
 * TestDecorator
 * 装饰器模式，场景：设计游戏装备，每个装备有数值，可镶嵌宝石
 * 如果加一点功能的装备创建一个类，会指数级增长，装备镶嵌一个宝石可看作是功能的增加，可考虑使用装饰器模式
 * @author rwei
 * @since 2023/3/13 17:40
 */
public class TestDecorator {
    public static void main(String[] args) {
        System.out.println("创建镶嵌一个蓝宝石和一个红宝石的武器");
        IEquip iEquip = new RedDecorator(new RedDecorator(new ArmEquip()));
        System.out.println(iEquip.calculateAttack());
        System.out.println(iEquip.description());
    }
}
