package com.ran.javase.designpattern.prototype.shapeimpl;

import com.ran.javase.designpattern.prototype.Shape;

/**
 * Circle
 *
 * @author rwei
 * @since 2023/3/26 21:54
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw()");
    }
}
