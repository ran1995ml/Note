package com.ran.designpattern.prototype;

/**
 * Rectangle
 *
 * @author rwei
 * @since 2023/6/27 17:39
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "rectangle";
    }

    @Override
    public void draw() {
        System.out.println("draw rectangle");
    }
}
