package com.ran.javase.designpattern.command.control;

import com.ran.javase.designpattern.command.control.impl.NoCommand;

/**
 * RemoteControl
 * 遥控器，命令请求者
 * @author rwei
 * @since 2023/4/4 17:44
 */
public class RemoteControl {
    Command[] onCommands;

    Command[] offCommands;

    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPress(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonPress(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-----Remote Control-----\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("slot ").append(i).
                    append(onCommands[i].getClass().getName()).append(" ").
                    append(offCommands[i].getClass().getName()).append("\n");
        }
        return sb.toString();
    }
}
