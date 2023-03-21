package com.ran.javase.designpattern.status;

/**
 * HasMoneyState
 *
 * @author rwei
 * @since 2023/3/14 18:06
 */
public class HasMoneyState implements State {

    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
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
