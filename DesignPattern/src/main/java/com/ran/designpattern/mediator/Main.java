package com.ran.designpattern.mediator;

/**
 * Main
 * 中介者模式
 * 聊天室场景，用户发的消息由中介者转发
 * @author rwei
 * @since 2023/6/27 15:50
 */
public class Main {
    public static void main(String[] args) {
        User tom = new User("Tom");
        User jack = new User("Jack");
        tom.sendMessage("Hi, I'm Tom");
        jack.sendMessage("Hi, I'm jack");
    }
}
