package com.ran.designpattern.builder;

/**
 * Builder
 * 抽象建造者
 * @author rwei
 * @since 2023/6/26 17:06
 */
public abstract class Builder {
    public abstract void setPart(String name, String type);

    public abstract Product getProduct();
}
