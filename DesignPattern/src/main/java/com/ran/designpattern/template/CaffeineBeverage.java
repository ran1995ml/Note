package com.ran.designpattern.template;

/**
 * CaffeineBeverage
 * 咖啡饮料抽象类
 * @author rwei
 * @since 2023/6/19 19:09
 */
public abstract class CaffeineBeverage {
    //以免子类修改
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    //钩子方法，子类可选择覆盖
    public boolean customerWantsCondiments() {
        return true;
    }

    public abstract void brew();

    public abstract void addCondiments();

    public void boilWater() {
        System.out.println("boil water");
    }

    public void pourInCup() {
        System.out.println("pour into cup");
    }
}
