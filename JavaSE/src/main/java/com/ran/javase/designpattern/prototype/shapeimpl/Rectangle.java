package com.ran.javase.designpattern.prototype.shapeimpl;

import com.ran.javase.designpattern.prototype.Shape;

/**
 * Rectangle
 *
 * @author rwei
 * @since 2023/3/26 21:55
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw()");
    }
}
