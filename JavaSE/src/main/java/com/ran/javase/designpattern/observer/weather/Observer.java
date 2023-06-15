package com.ran.javase.designpattern.observer.weather;

/**
 * Observer
 *
 * @author rwei
 * @since 2023/3/30 17:32
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
