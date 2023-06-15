package com.ran.javase.designpattern.flyweight;

/**
 * Circle
 *
 * @author rwei
 * @since 2023/3/28 15:40
 */
public class Circle implements Shape {
    private String color;

    private int x;

    private int y;

    private int radius;

    public Circle(String color) {
        this.color = color;
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

    @Override
    public void draw() {
        System.out.printf("color: %s, x: %d, y: %d, radius: %s%n", color, x, y, radius);
    }
}
