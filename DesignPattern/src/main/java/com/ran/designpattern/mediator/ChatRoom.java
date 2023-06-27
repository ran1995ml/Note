package com.ran.designpattern.mediator;

import java.util.Date;

/**
 * ChatRoom
 * 中介类
 * @author rwei
 * @since 2023/6/27 15:46
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] " + message);
    }
}
