package com.ran.designpattern.observer;

/**
 * CurrentConditionDisplay
 * 观察者实现类，订阅主题
 * @author rwei
 * @since 2023/6/14 22:08
 */
public class CurrentConditionDisplay implements Observer {
    private Subject subject;

    private float temperature;

    public CurrentConditionDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    private void display() {
        System.out.println("temperature: " + temperature);
    }


}
