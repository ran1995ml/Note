package com.ran.javase.designpattern.observer;

/**
 * ObserverImplA
 *
 * @author rwei
 * @since 2023/2/22 11:45
 */
public class ObserverImpl implements Observer {
    private Subject subject;

    public ObserverImpl(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println(this + "Get message");
    }
}
