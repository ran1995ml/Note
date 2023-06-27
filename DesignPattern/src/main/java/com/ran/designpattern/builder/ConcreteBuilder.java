package com.ran.designpattern.builder;

/**
 * ConcreteBuilder
 * 具体的建造者
 * @author rwei
 * @since 2023/6/26 17:08
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
