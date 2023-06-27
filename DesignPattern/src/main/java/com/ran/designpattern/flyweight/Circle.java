package com.ran.designpattern.flyweight;

/**
 * Circle
 *
 * @author rwei
 * @since 2023/6/27 13:15
 */
public class Circle implements Shape {
    private String color;

    private int x;

    private int y;

    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        String circle = "Circle{" +
                "color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
        System.out.println(circle);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
