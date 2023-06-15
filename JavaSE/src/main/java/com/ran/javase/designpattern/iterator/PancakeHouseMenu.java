package com.ran.javase.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * PancakeHouseMenu
 *
 * @author rwei
 * @since 2023/4/7 11:24
 */
public class PancakeHouseMenu {
    List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("Breakfast", "eggs", true, 2.99);
    }

    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }
}
