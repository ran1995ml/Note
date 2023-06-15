package com.ran.javase.designpattern.observer.weather.impl;

import com.ran.javase.designpattern.observer.weather.DisplayElement;
import com.ran.javase.designpattern.observer.weather.Observer;
import com.ran.javase.designpattern.observer.weather.Subject;

/**
 * CurrentConditionsDisplay
 * 观察者实现类，订阅主题
 * @author rwei
 * @since 2023/3/30 17:47
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;

    private float humidity;

    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: temperature %s, humidity %s%n", temperature, humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        //update是最适合调用display的？当前场景，变化时调用display是合理的。有更好的方式设计，如MVC
        display();
    }
}
