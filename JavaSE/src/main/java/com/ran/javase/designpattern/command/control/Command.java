package com.ran.javase.designpattern.command.control;

/**
 * Command
 *
 * @author rwei
 * @since 2023/4/4 17:41
 */
public interface Command {
    public void execute();

    public void undo();
}
