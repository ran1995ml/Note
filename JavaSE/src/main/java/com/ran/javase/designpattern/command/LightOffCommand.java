package com.ran.javase.designpattern.command;

/**
 * LightOffCommand
 *
 * @author rwei
 * @since 2023/3/13 11:22
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
