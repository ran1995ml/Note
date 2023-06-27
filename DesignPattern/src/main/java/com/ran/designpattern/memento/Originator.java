package com.ran.designpattern.memento;

/**
 * Originator
 * 创建状态，存储进Memento
 * @author rwei
 * @since 2023/6/27 16:39
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
