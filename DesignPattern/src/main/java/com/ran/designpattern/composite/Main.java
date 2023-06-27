package com.ran.designpattern.composite;

import java.util.*;

/**
 * Main
 * 组合模式
 * @author rwei
 * @since 2023/6/20 14:59
 */
public class Main {
    public static void main(String[] args) {
        MenuComponent breakfastMenu = new Menu("breakfast", "breakfast");
        MenuComponent dinnerMenu = new Menu("dinner", "dinner");
        MenuComponent pieMenu = new Menu("pie", "pie");
        MenuComponent menus = new Menu("all menus", "all menus");

        menus.add(breakfastMenu);
        menus.add(dinnerMenu);
        dinnerMenu.add(new MenuItem("drink", "drink", false, 10.99));
        dinnerMenu.add(pieMenu);
        breakfastMenu.add(new MenuItem("jiaozi", "jiaozi", false, 20.99));

//        Waitress waitress = new Waitress(menus);
//        waitress.printMenu();
        Iterator<MenuComponent> iterator = Collections.singletonList(menus).iterator();
        //内部迭代器
        print(iterator);
    }

    public static void print(Iterator<MenuComponent> iterator) {
        CompositeIterator compositeIterator = new CompositeIterator(iterator);
        while (compositeIterator.hasNext()) {
            MenuComponent component = compositeIterator.next();
            component.print();
        }
    }
}
