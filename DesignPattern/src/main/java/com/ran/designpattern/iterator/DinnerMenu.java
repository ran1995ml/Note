package com.ran.designpattern.iterator;

import java.util.Iterator;

/**
 * DinnerMenu
 * 用数组实现的菜单，可控制长度
 * @author rwei
 * @since 2023/6/20 10:53
 */
public class DinnerMenu implements Menu {
    private static final int MAX_ITEMS = 6;

    private int numberOfItems = 0;

    private MenuItem[] menuItems;

    public DinnerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItems("tufu", "tufu", true, 1.99);
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinnerMenuIterator(menuItems);
    }

    public void addItems(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems > MAX_ITEMS) {
            System.out.println("Error");
        } else {
            menuItems[numberOfItems++] = menuItem;
        }
    }
}
