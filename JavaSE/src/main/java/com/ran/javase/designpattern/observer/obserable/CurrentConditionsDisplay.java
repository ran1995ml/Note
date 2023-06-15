package com.ran.javase.designpattern.observer.obserable;

import com.ran.javase.designpattern.observer.weather.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * CurrentConditionsDisplay
 *
 * @author rwei
 * @since 2023/4/2 20:38
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;

    private float temperature;

    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.printf("Current conditions: temperature %s, humidity %s%n", temperature, humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
