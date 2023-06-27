package com.ran.designpattern.proxy.virtual;

/**
 * Main
 * 代理模式
 * @author rwei
 * @since 2023/6/25 22:16
 */
public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("picture.png");
        image.display();
    }
}
