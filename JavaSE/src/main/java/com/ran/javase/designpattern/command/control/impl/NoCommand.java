package com.ran.javase.designpattern.command.control.impl;

import com.ran.javase.designpattern.command.control.Command;

/**
 * NoCommand
 *
 * @author rwei
 * @since 2023/4/4 17:59
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("no command");
    }
}
