package com.ran.designpattern.command;

/**
 * Command
 * 命令接口
 * @author rwei
 * @since 2023/6/16 17:56
 */
public interface Command {
    //提供给调用者执行相关命令
    public void execute();

    public void undo();
}
