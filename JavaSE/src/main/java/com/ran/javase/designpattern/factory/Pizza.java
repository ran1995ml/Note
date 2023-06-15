package com.ran.javase.designpattern.factory;

/**
 * Pizza
 *
 * @author rwei
 * @since 2023/4/3 15:12
 */
public abstract class Pizza {
    protected String type;
    
    public void prepare() {
        System.out.println("prepare");
    }
    
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
