package com.ran.javase.designpattern.decorator.coffee;

/**
 * HouseBlend
 *
 * @author rwei
 * @since 2023/4/2 22:23
 */
public class HouseBlend extends Beverage{
    public HouseBlend() {
        description = "HouseBlend";
    }
    
    @Override
    public double cost() {
        return 0.89;
    }
}
