package com.ran.designpattern.builder;

/**
 * Main
 *
 * @author rwei
 * @since 2023/6/26 17:11
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Product aProduct = director.getAProduct();
        Product bProduct = director.getBProduct();
    }
}
