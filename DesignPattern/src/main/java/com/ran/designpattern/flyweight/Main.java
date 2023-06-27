package com.ran.designpattern.flyweight;

/**
 * Main
 * 享元模式，重复利用已有对象
 * @author rwei
 * @since 2023/6/27 13:42
 */
public class Main {
    private static final String[] colors = {"Red", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String color = getColor();
            Circle circle = (Circle) ShapeFactory.getCircle(color);
            circle.setX(0);
            circle.setY(0);
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getColor() {
        return colors[(int)(Math.random() * colors.length)];
    }
}
