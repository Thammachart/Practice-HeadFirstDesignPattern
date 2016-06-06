package org.diner.menus.iterators;

import java.util.Iterator;

import org.diner.menus.MenuComponent;

public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public MenuComponent next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
