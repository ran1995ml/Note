package com.ran.designpattern.iterator;

import java.util.Iterator;

/**
 * DinnerMenuIterator
 *
 * @author rwei
 * @since 2023/6/20 11:05
 */
public class DinnerMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] items;

    private int position;

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
    public MenuItem next() {
        return items[position++];
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("Can't remove before done at least next()");
        }
        if (items[position - 1] != null) {
            for (int i = position - 1; i < items.length - 1; i++) {
                items[i] = items[i + 1];
            }
            items[items.length - 1] = null;
        }
    }
}
