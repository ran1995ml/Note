package com.ran.designpattern.builder;

/**
 * Director
 * 导演类，调用建造者
 * @author rwei
 * @since 2023/6/26 17:09
 */
public class Director {
    private Builder builder = new ConcreteBuilder();

    public Product getAProduct() {
        builder.setPart("A", "A");
        return builder.getProduct();
    }

    public Product getBProduct() {
        builder.setPart("B", "B");
        return builder.getProduct();
    }
}
