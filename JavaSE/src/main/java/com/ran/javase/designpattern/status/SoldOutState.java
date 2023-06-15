package com.ran.javase.designpattern.status;

/**
 * SoldOutState
 * 售罄状态
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
        System.out.println("insert money failed, sold out.");
    }

    @Override
    public void backMoney() {
        System.out.println("not insert money, do you want to back money?");
    }

    @Override
    public void turnCrank() {
        System.out.println("sold out, turn grank is invalid.");
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("Invalid state!");
    }
}
