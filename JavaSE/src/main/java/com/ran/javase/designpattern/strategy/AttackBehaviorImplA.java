package com.ran.javase.designpattern.strategy;

/**
 * AttackBehaviorImplA
 *
 * @author rwei
 * @since 2023/3/6 10:07
 */
public class AttackBehaviorImplA implements IAttackBehavior{
    @Override
    public void attack() {
        System.out.println("attack A");
    }
}
