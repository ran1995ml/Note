package com.ran.javase.designpattern.command;

/**
 * NoCommand
 *
 * @author rwei
 * @since 2023/3/13 15:27
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("no command");
    }
}
