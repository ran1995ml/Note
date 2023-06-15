package com.ran.javase.designpattern.proxy;

/**
 * ProxyImage
 *
 * @author rwei
 * @since 2023/3/28 17:15
 */
public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
