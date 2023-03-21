package com.ran.javase.designpattern.command;

/**
 * ControlPanel
 *
 * @author rwei
 * @since 2023/3/13 13:43
 */
public class ControlPanel {
    private static final int CONTROL_SIZE = 9;

    private Command[] commands;

    public ControlPanel() {
        commands = new Command[CONTROL_SIZE];
        for (int i = 0; i < CONTROL_SIZE; i++) {
            commands[i] = new NoCommand();
        }
    }

    public void setCommands(int index, Command command) {
        commands[index] = command;
    }

    public void keyPress(int index) {
        commands[index].execute();
    }

}
