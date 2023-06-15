package com.ran.javase.designpattern.status;

/**
 * TestState
 *
 * @author rwei
 * @since 2023/3/26 18:29
 */
public class TestState {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(10);
        vendingMachine.insertMoney();
        vendingMachine.backMoney();

        vendingMachine.insertMoney();
        vendingMachine.turnCrank();

        vendingMachine.insertMoney();
        vendingMachine.backMoney();
        vendingMachine.backMoney();
        vendingMachine.turnCrank();
    }
}
