package com.ran.javase.designpattern.observer.weather;

import com.ran.javase.designpattern.observer.weather.impl.CurrentConditionsDisplay;
import com.ran.javase.designpattern.observer.weather.impl.WeatherData;

/**
 * TestWeatherStation
 * 这种模式是subject推数据，有时候需要
 * @author rwei
 * @since 2023/3/30 17:57
 */
public class TestWeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        //模拟气象数据变化
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(70, 45, 20.4f);

    }
}
