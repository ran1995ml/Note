package com.ran.javase.designpattern.observer.obserable;



/**
 * TestObservable
 * Observable是一个类，必须继承才能使用，且setChanged被保护起来，不能使用组合
 * @author rwei
 * @since 2023/4/2 20:48
 */
public class TestObservable {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        //模拟气象数据变化
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(70, 45, 20.4f);
    }
}
