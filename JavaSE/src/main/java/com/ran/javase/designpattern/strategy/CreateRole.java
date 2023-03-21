package com.ran.javase.designpattern.strategy;

/**
 * CreateRole
 *
 * @author rwei
 * @since 2023/3/6 10:10
 */
public class CreateRole {
    public static void main(String[] args) {
        new RoleA("A").setAttackBehavior(new AttackBehaviorImplA())
                .setDefendBehavior(new DefendBehaviorImplA());
    }
}
