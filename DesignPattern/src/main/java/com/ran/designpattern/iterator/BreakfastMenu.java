package com.ran.designpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PancakeHouseMenu
 * 用arraylist实现的菜单
 * @author rwei
 * @since 2023/6/20 10:27
 */
public class BreakfastMenu implements Menu {
    private List<MenuItem> menuItemList;

    public BreakfastMenu() {
        this.menuItemList = new ArrayList<>();
        addItems("Pancake", "egg, milk", true, 2.99);
        addItems("burger", "meat", false, 10.99);
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItemList.iterator();
    }

    public void addItems(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItemList.add(menuItem);
    }
}
