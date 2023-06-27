package com.ran.designpattern.bridge;

/**
 * Main
 *
 * @author rwei
 * @since 2023/6/26 16:53
 */
public class Main {
    public static void main(String[] args) {
        Circle red = new Circle(new RedCircle(), 0, 0, 100);
        red.draw();
    }
}
