package com.ran.javase.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Server3D
 *
 * @author rwei
 * @since 2023/2/22 11:18
 */
public class SubjectImpl implements Subject{
    private String msg;

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index > 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(msg));
    }

    /**
     * 更新主题消息通知观察者
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();
    }
}
