package com.ran.javase.designpattern.command.control.impl;

import com.ran.javase.designpattern.command.control.Command;
import com.ran.javase.designpattern.command.control.Light;

/**
 * LightOnCommand
 * 打开电灯命令
 * @author rwei
 * @since 2023/4/4 17:42
 */
public class LightOnCommand implements Command {
    Light light;

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
