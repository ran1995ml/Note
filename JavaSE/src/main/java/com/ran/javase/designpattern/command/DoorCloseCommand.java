package com.ran.javase.designpattern.command;

/**
 * DoorCloseCommand
 *
 * @author rwei
 * @since 2023/3/13 11:25
 */
public class DoorCloseCommand implements Command {
    private Door door;

    public DoorCloseCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        System.out.println("door close");
    }
}
