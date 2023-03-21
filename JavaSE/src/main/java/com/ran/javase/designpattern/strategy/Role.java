package com.ran.javase.designpattern.strategy;

/**
 * Role
 * 策略设计模式
 * 设计游戏角色，每个角色有不同的攻击、防御技能
 * 将技能抽象出来，这些技能相当于算法族，role相当于客户
 * @author rwei
 * @since 2023/3/6 09:59
 */
public abstract class Role {
    protected String name;

    protected IDefendBehavior defendBehavior;

    protected IAttackBehavior attackBehavior;

    public Role setDefendBehavior(IDefendBehavior defendBehavior) {
        this.defendBehavior = defendBehavior;
        return this;
    }

    public Role setAttackBehavior(IAttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
        return this;
    }

    public void defend() {
        this.defendBehavior.defend();
    }

    public void attack() {
        this.attackBehavior.attack();
    }
}
