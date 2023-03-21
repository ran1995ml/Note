package com.ran.javase.designpattern.status;

/**
 * NoMoneyState
 *
 * @author rwei
 * @since 2023/3/14 11:22
 */
public class NoMoneyState implements State{
    private VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("insert money");

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
