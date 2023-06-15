package com.ran.javase.designpattern.status;

/**
 * NoMoneyState
 * 未投币状态
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
        System.out.println("insert money success");
        vendingMachine.setState(vendingMachine.getHasMoneyState());
    }

    @Override
    public void backMoney() {
        System.out.println("no money, do you want to back money?");
    }

    @Override
    public void turnCrank() {
        System.out.println("no money, do you want to get things");
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("Invalid state!");
    }
}
