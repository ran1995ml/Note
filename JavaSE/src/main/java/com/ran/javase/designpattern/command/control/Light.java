package com.ran.javase.designpattern.command.control;

/**
 * Light
 *
 * @author rwei
 * @since 2023/4/4 17:43
 */
public class Light {
    String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(this.name + " light on");
    }

    public void off() {
        System.out.println(this.name + " light off");
    }
}
