package com.ran.javase.designpattern.command;

/**
 * DoorOpenCommand
 *
 * @author rwei
 * @since 2023/3/13 11:23
 */
public class DoorOpenCommand implements Command {
    private Door door;

    public DoorOpenCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }
}
