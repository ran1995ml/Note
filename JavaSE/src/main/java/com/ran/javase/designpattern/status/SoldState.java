package com.ran.javase.designpattern.status;

/**
 * SoldState
 * 准备售出商品状态，该状态无任何用户操作
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
        System.out.println("sold thing, don't insert money.");
    }

    @Override
    public void backMoney() {
        System.out.println("sold thing, can't back money.");
    }

    @Override
    public void turnCrank() {
        System.out.println("sold thing, don't turn grank.");
    }

    @Override
    public void dispense() {
        vendingMachine.dispense();
        if (vendingMachine.getCount() > 0) {
            vendingMachine.setState(vendingMachine.getNoMoneyState());
        } else {
            System.out.println("things sold out");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        }
    }
}
