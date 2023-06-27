package com.ran.designpattern.bridge;

/**
 * Shape
 * 抽象类，依赖桥接类
 * @author rwei
 * @since 2023/6/26 16:36
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
