package com.ran.javase.designpattern.command.control.impl;

import com.ran.javase.designpattern.command.control.Command;
import com.ran.javase.designpattern.command.control.Stereo;

/**
 * StereoOffCommand
 *
 * @author rwei
 * @since 2023/4/5 21:58
 */
public class StereoOffCommand implements Command {
    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
