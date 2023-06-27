package com.ran.designpattern.state;

/**
 * SoldOutState
 *
 * @author rwei
 * @since 2023/6/21 13:57
 */
public class SoldOutState implements State {
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sold out");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sold out");
    }

    @Override
    public void dispense() {
        System.out.println("Sold out");
    }
}
