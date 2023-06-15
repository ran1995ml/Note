package com.ran.javase.designpattern.factory.abstractfactory;

/**
 * Pizza
 * 需要自定义原料的pizza
 * @author rwei
 * @since 2023/4/3 17:22
 */
public abstract class Pizza {
    protected String type;
    
    public abstract void prepare();

    public void bake() {
        System.out.println("bake");
    }

    public void cut() {
        System.out.println("cut");
    }

    public void box() {
        System.out.println("box");
    }
}
