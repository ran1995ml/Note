package com.ran.designpattern.composite;

import java.util.Iterator;

/**
 * MenuItem
 * 组合类图里的叶类，实现组合内元素的行为
 * @author rwei
 * @since 2023/6/20 14:42
 */
public class MenuItem extends MenuComponent {
    private String name;

    private String description;

    private boolean vegetarian;

    private double price;

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

    @Override
    public void print() {
        String menuItem = "MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                '}';
        System.out.println(menuItem);
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }
}
