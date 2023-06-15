package com.ran.javase.designpattern.status;

import java.util.Random;

/**
 * HasMoneyState
 * 已投钱的状态
 * @author rwei
 * @since 2023/3/14 18:06
 */
public class HasMoneyState implements State {

    private VendingMachine vendingMachine;

    private Random random = new Random();

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("you have insert money!");
    }

    @Override
    public void backMoney() {
        System.out.println("back money success!");
        vendingMachine.setState(vendingMachine.getNoMoneyState());
    }

    @Override
    public void turnCrank() {
        System.out.println("you turn the grank");
        int winner = random.nextInt(10);
        if (winner == 0 && vendingMachine.getCount() > 1) {
            vendingMachine.setState(vendingMachine.getWinnerState());
        } else {
            vendingMachine.setState(vendingMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("Invalid State!");
    }
}
