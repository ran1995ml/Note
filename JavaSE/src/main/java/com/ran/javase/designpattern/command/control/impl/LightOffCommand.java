package com.ran.javase.designpattern.command.control.impl;

import com.ran.javase.designpattern.command.control.Command;
import com.ran.javase.designpattern.command.control.Light;

/**
 * LightOffCommand
 *
 * @author rwei
 * @since 2023/4/5 21:52
 */
public class LightOffCommand implements Command {
    Light light;

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
