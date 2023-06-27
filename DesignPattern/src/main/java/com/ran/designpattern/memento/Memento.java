package com.ran.designpattern.memento;

/**
 * Memento
 * 存储对象状态
 * @author rwei
 * @since 2023/6/27 16:37
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
