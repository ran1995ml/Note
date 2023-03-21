package com.ran.javase.designpattern.observer;

/**
 * Subject
 *
 * @author rwei
 * @since 2023/2/22 11:08
 */
public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
