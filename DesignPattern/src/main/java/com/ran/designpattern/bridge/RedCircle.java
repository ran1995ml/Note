package com.ran.designpattern.bridge;

/**
 * RedCircle
 * 桥接实现类
 * @author rwei
 * @since 2023/6/26 16:40
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("x:" + x + " y:" + y + " radius:" + radius);
    }
}
