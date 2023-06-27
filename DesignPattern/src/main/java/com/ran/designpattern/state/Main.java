package com.ran.designpattern.state;

/**
 * Main
 *
 * @author rwei
 * @since 2023/6/22 10:17
 */
public class Main {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
