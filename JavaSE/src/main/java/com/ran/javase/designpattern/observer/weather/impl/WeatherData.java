package com.ran.javase.designpattern.observer.weather.impl;

import com.ran.javase.designpattern.observer.weather.Observer;
import com.ran.javase.designpattern.observer.weather.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * WeatherData
 * 主题实现类，保存观察者列表和变化的数据
 * @author rwei
 * @since 2023/3/30 17:36
 */
public class WeatherData implements Subject {
    private List<Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
