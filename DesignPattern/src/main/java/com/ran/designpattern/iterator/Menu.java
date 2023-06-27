package com.ran.designpattern.iterator;

import java.util.Iterator;

/**
 * Menue
 *
 * @author rwei
 * @since 2023/6/20 11:29
 */
public interface Menu {
    public Iterator<MenuItem> createIterator();
}
