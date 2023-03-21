package com.ran.javase.designpattern.status;

/**
 * SoldOutState
 *
 * @author rwei
 * @since 2023/3/14 18:07
 */
public class SoldOutState implements State {
    private VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {

    }

    @Override
    public void backMoney() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
