package com.ran.javase.designpattern.status;

/**
 * WinnerState
 *
 * @author rwei
 * @since 2023/3/14 18:13
 */
public class WinnerState implements State {
    private VendingMachine vendingMachine;

    public WinnerState(VendingMachine vendingMachine) {
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
