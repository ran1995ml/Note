package com.ran.javase.designpattern.builder;

/**
 * Director
 * 建造者模式，场景：汽车创建
 * @author rwei
 * @since 2023/3/26 21:07
 */
public class Director {
    private Builder builder = new ConcreteBuilder();

    public Product getAProduct() {
        builder.setPart("奥迪", "Q5");
        return builder.getProduct();
    }

    public Product getBProduct() {
        builder.setPart("宝马", "X7");
        return builder.getProduct();
    }

}
