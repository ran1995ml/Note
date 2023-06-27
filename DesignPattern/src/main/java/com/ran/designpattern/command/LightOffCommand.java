package com.ran.designpattern.command;

/**
 * LightOffCommand
 *
 * @author rwei
 * @since 2023/6/16 18:16
 */
public class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
