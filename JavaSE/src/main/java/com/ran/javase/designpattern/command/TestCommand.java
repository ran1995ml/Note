package com.ran.javase.designpattern.command;

import com.ran.javase.designpattern.command.control.Light;
import com.ran.javase.designpattern.command.control.RemoteControl;
import com.ran.javase.designpattern.command.control.Stereo;
import com.ran.javase.designpattern.command.control.impl.LightOffCommand;
import com.ran.javase.designpattern.command.control.impl.LightOnCommand;
import com.ran.javase.designpattern.command.control.impl.StereoOffCommand;
import com.ran.javase.designpattern.command.control.impl.StereoOnCommand;

/**
 * TestCommand
 * 执行的统一接口
 * @author rwei
 * @since 2023/4/4 17:40
 */
public class TestCommand {
    public static void main(String[] args) {
        Light livingLight = new Light("living room");
        Light wcLight = new Light("wc");
        Stereo stereo = new Stereo("living room");
        LightOnCommand livingLightOnCommand = new LightOnCommand(livingLight);
        LightOffCommand livingLightOffCommand = new LightOffCommand(livingLight);
        LightOnCommand wcLightOnCommand = new LightOnCommand(wcLight);
        LightOffCommand wcLightOffCommand = new LightOffCommand(wcLight);
        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, livingLightOnCommand, livingLightOffCommand);
        remoteControl.setCommand(1, wcLightOnCommand, wcLightOffCommand);
        remoteControl.setCommand(2, stereoOnCommand, stereoOffCommand);
        System.out.println(remoteControl);

        remoteControl.onButtonPress(0);
        remoteControl.offButtonPress(0);
        remoteControl.onButtonPress(1);
        remoteControl.offButtonPress(1);
        remoteControl.onButtonPress(2);
        remoteControl.offButtonPress(2);
    }
}
