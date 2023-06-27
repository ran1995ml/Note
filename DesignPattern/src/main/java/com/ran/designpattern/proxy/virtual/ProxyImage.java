package com.ran.designpattern.proxy.virtual;

/**
 * ProxyImage
 * 代理类
 * @author rwei
 * @since 2023/6/25 22:14
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
