package com.ran.javase.designpattern.command;

/**
 * TestCommand
 * 命令模式，场景：遥控器，每个按钮代表一个命令，集成命令
 * @author rwei
 * @since 2023/3/13 15:30
 */
public class TestCommand {
    public static void main(String[] args) {
        Light light = new Light();
        Door door = new Door();
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setCommands(0, new LightOnCommand(light));
        controlPanel.setCommands(1, new LightOffCommand(light));
        controlPanel.setCommands(2, new DoorOpenCommand(door));
        controlPanel.setCommands(3, new DoorCloseCommand(door));

        controlPanel.keyPress(0);
        controlPanel.keyPress(1);
        controlPanel.keyPress(2);
        controlPanel.keyPress(3);
    }
}
