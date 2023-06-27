package com.ran.designpattern.command;

/**
 * Main
 * 命令模式
 * @author rwei
 * @since 2023/6/16 18:06
 */
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.executeCommand();
    }
}
