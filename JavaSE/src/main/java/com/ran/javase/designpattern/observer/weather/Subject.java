package com.ran.javase.designpattern.observer.weather;

/**
 * Subject
 *
 * @author rwei
 * @since 2023/3/30 17:34
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
