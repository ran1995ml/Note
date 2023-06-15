package com.ran.javase.designpattern.command.control.impl;

import com.ran.javase.designpattern.command.control.Command;
import com.ran.javase.designpattern.command.control.Stereo;

/**
 * StereoOnCommand
 *
 * @author rwei
 * @since 2023/4/5 21:57
 */
public class StereoOnCommand implements Command {
    Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
