package com.ran.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * ShapeFactory
 * 工厂生成
 * @author rwei
 * @since 2023/6/27 13:35
 */
public class ShapeFactory {
    private static final Map<String, Shape> map = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle =(Circle) map.get(color);
        if (circle == null) {
            System.out.println("Creating new circle");
            circle = new Circle(color);
            map.put(color, circle);
        }
        return circle;
    }
}
