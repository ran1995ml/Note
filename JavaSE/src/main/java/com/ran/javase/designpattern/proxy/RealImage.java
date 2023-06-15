package com.ran.javase.designpattern.proxy;

/**
 * RealImage
 * 实体类
 * @author rwei
 * @since 2023/3/28 17:08
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.printf("Loading disk %s%n", fileName);
    }

    @Override
    public void display() {
        System.out.printf("Realtime %s Displaying%n", fileName);
    }
}
