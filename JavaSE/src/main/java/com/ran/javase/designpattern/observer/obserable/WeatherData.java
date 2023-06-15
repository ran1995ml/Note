package com.ran.javase.designpattern.observer.obserable;

import java.util.Observable;

/**
 * WeatherData
 * jdk内置观察者模式实现，可实现push或者pull
 * @author rwei
 * @since 2023/3/31 18:09
 */
public class WeatherData extends Observable {
    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {}

    public void measurementsChanged() {
        //更新观察者有更多弹性，可适当通知观察者，指示状态已经改变
        setChanged();
        //没有使用notify传送数据，表示pull数据
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    //当使用pull，获取状态
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
