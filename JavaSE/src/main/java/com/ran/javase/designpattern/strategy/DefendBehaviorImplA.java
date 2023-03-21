package com.ran.javase.designpattern.strategy;

/**
 * DefendBehaviorImplA
 *
 * @author rwei
 * @since 2023/3/6 10:08
 */
public class DefendBehaviorImplA implements IDefendBehavior{

    @Override
    public void defend() {
        System.out.println("defend A");
    }
}
