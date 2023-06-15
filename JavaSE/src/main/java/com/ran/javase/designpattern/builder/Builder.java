package com.ran.javase.designpattern.builder;

/**
 * Builder
 * 抽象建造者
 * @author rwei
 * @since 2023/3/26 18:52
 */
public abstract class Builder {
    public abstract void setPart(String name, String type);

    public abstract Product getProduct();
}
