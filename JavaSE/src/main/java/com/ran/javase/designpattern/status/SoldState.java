package com.ran.javase.designpattern.status;

/**
 * SoldState
 *
 * @author rwei
 * @since 2023/3/14 18:13
 */
public class SoldState implements State {
    private VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
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
