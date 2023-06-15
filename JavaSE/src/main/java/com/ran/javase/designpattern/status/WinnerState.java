package com.ran.javase.designpattern.status;

/**
 * WinnerState
 * 中奖状态，该状态不会有任何用户操作
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
        throw new IllegalStateException("Invalid state.");
    }

    @Override
    public void backMoney() {
        throw new IllegalStateException("Invalid state.");
    }

    @Override
    public void turnCrank() {
        throw new IllegalStateException("Invalid state.");
    }

    @Override
    public void dispense() {
        System.out.println("Winner! Get double things.");
        vendingMachine.dispense();
        if (vendingMachine.getCount() == 0) {
            System.out.println("Sold out");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        } else {
            vendingMachine.dispense();
            if (vendingMachine.getCount() > 0) {
                vendingMachine.setState(vendingMachine.getNoMoneyState());
            } else{
                System.out.println("Sold out");
                vendingMachine.setState(vendingMachine.getSoldOutState());
            }
        }
    }
}
