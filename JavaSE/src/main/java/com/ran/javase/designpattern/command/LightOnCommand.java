package com.ran.javase.designpattern.command;

/**
 * LightOnCommand
 *
 * @author rwei
 * @since 2023/3/13 11:21
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
