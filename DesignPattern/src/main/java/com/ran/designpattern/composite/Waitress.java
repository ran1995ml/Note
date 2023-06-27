package com.ran.designpattern.composite;

/**
 * Waitress
 *
 * @author rwei
 * @since 2023/6/20 14:56
 */
public class Waitress {
    private MenuComponent menuComponent;

    public Waitress(MenuComponent menuComponent) {
        this.menuComponent = menuComponent;
    }

    public void printMenu() {
        menuComponent.print();
    }
}
