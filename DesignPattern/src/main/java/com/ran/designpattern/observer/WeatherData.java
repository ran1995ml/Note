package com.ran.designpattern.observer;

import java.util.ArrayList;

/**
 * WeatherData
 * 收集观测数据，通知观察者
 * @author rwei
 * @since 2023/6/14 21:57
 */
public class WeatherData implements Subject {
    private ArrayList<Observer> observers;

    private float temperature;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(temperature);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature) {
        this.temperature = temperature;
        //值变化时，立即通知观察者
        measurementsChanged();
    }
}
