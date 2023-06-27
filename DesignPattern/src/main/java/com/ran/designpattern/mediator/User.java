package com.ran.designpattern.mediator;

/**
 * User
 *
 * @author rwei
 * @since 2023/6/27 15:47
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
