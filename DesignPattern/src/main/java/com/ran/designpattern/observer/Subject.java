package com.ran.designpattern.observer;

/**
 * Subject
 * 主题接口
 * @author rwei
 * @since 2023/6/14 21:52
 */
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
