package com.ran.javase.designpattern.iterator;

import java.util.List;

/**
 * PancakeHouseMenuIterator
 *
 * @author rwei
 * @since 2023/4/8 22:24
 */
public class PancakeHouseMenuIterator implements Iterator{
    List<MenuItem> menuItems;

    int position;

    public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size() || menuItems.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems.get(position);
        position++;
        return menuItem;
    }
}
