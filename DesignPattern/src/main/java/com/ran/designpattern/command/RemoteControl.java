package com.ran.designpattern.command;

/**
 * RemoteControl
 * 调用者对象
 * @author rwei
 * @since 2023/6/16 18:01
 */
public class RemoteControl {
    Command command;

    Command undoCommand;

    public RemoteControl() {}

    //传入命令对象
    public void setCommand(Command command) {
        this.command = command;
    }

    //执行命令
    public void executeCommand() {
        command.execute();
        undoCommand = command;
    }
}
