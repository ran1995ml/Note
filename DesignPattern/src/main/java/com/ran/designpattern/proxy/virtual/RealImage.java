package com.ran.designpattern.proxy.virtual;

/**
 * RealImage
 * 实体类
 * @author rwei
 * @since 2023/6/25 22:09
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    public void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
