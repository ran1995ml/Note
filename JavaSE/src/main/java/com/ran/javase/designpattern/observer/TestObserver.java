package com.ran.javase.designpattern.observer;

/**
 * MainApplication
 *
 * @author rwei
 * @since 2023/2/22 13:25
 */
public class TestObserver {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        ObserverImpl observerA = new ObserverImpl(subject);
        ObserverImpl observerB = new ObserverImpl(subject);
        subject.setMsg("Sending msg......");
    }
}
