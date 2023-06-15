package com.ran.javase.designpattern.iterator;

/**
 * DinnerMenuIterator
 *
 * @author rwei
 * @since 2023/4/7 18:02
 */
public class DinnerMenuIterator implements Iterator {
    MenuItem[] items;

    int position;

    public DinnerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem item = items[position];
        position++;
        return item;
    }
}
