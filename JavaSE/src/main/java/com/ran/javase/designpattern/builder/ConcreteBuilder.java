package com.ran.javase.designpattern.builder;

/**
 * ConcreteBuilder
 * 具体构造者
 * @author rwei
 * @since 2023/3/26 21:02
 */
public class ConcreteBuilder extends Builder {
    private Product product = new Product();

    @Override
    public void setPart(String name, String type) {
        product.setName(name);
        product.setType(type);
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
