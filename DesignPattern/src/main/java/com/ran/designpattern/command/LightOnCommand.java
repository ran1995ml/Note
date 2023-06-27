package com.ran.designpattern.command;

/**
 * LightOnCommand
 * 命令对象
 * @author rwei
 * @since 2023/6/16 17:57
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

    @Override
    public void undo() {
        light.off();
    }
}
