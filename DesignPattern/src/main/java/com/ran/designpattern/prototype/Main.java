package com.ran.designpattern.prototype;

/**
 * Main
 * 原型模式
 * @author rwei
 * @since 2023/6/27 17:47
 */
public class Main {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("1");
        System.out.println(shape.getType());
    }
}
