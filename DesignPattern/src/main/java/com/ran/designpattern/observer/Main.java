package com.ran.designpattern.observer;

/**
 * Main
 * 观察者模式
 * @author rwei
 * @since 2023/6/14 22:10
 */
public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80);
        weatherData.setMeasurements(90);
        weatherData.removeObserver(currentConditionDisplay);
        weatherData.setMeasurements(100);
    }
}
