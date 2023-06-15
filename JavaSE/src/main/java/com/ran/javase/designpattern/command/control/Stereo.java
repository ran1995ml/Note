package com.ran.javase.designpattern.command.control;

/**
 * Stereo
 * 音响类
 * @author rwei
 * @since 2023/4/5 21:55
 */
public class Stereo {
    String name;

    public Stereo(String name) {
        this.name = name;
    }
    public void on() {
        System.out.println(this.name + " stereo on");
    }

    public void off() {
        System.out.println(this.name + " stereo off");
    }
}
