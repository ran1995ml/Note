package com.ran.javase.designpattern.iterator;

/**
 * MenuItem
 *
 * @author rwei
 * @since 2023/4/7 11:21
 */
public class MenuItem {
    String name;

    String description;

    boolean vegetarian;

    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}
