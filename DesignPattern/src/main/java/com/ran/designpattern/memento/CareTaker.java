package com.ran.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * CareTaker
 * 从Memento恢复状态
 * @author rwei
 * @since 2023/6/27 17:02
 */
public class CareTaker {
    private List<Memento> mementos = new ArrayList<>();

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento get(int index) {
        return mementos.get(index);
    }
}
