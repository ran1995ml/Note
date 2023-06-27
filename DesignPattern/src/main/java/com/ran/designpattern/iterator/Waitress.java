package com.ran.designpattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Waitress
 * 聚合类，遍历集合
 * @author rwei
 * @since 2023/6/20 13:31
 */
public class Waitress {
    private List<Menu> menuList;

    public Waitress(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void printMenu() {
        Iterator<Menu> iterator = menuList.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            Iterator<MenuItem> menuIterator = menu.createIterator();
            printMenu(menuIterator);
        }
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem.toString());
        }
    }
}
