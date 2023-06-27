package com.ran.designpattern.composite;

import java.util.Iterator;

/**
 * NullIterator
 *
 * @author rwei
 * @since 2023/6/20 18:00
 */
public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
