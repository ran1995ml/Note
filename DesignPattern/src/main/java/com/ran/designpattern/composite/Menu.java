package com.ran.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Menu
 * 组合类，持有菜单或其他菜单
 * @author rwei
 * @since 2023/6/20 14:48
 */
public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<>();

    private String name;

    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        String items =  "Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
        System.out.println(items);
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }


}
