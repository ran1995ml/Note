package com.ran.javase.designpattern.builder;

/**
 * Product
 *
 * @author rwei
 * @since 2023/3/26 18:53
 */
public class Product {
    String name;

    String type;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void showProduct() {
        System.out.printf("name:%s, type:%s%n", name, type);
    }
}
