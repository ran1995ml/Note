package com.ran.javase.designpattern.flyweight;

import java.util.HashMap;

/**
 * ShapeFactory
 *
 * @author rwei
 * @since 2023/3/28 15:50
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getShape(String color) {
        Shape shape = circleMap.get(color);
        if (shape == null) {
            shape = new Circle(color);
            circleMap.put(color, shape);
        }
        return shape;
    }
}
