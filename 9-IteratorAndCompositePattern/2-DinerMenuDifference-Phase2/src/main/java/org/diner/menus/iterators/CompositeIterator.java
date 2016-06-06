package org.diner.menus.iterators;

import org.diner.menus.MenuComponent;

import java.util.Iterator;

import java.util.Deque;
import java.util.ArrayDeque;

public class CompositeIterator implements Iterator<MenuComponent> {
    Deque<Iterator<MenuComponent>> stack;

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack = new ArrayDeque<>();
        stack.push(iterator);
    }

    @Override
    public MenuComponent next() {
        if(hasNext()) {
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent menuComponent = iterator.next();

            stack.push(menuComponent.iterator());

            return menuComponent;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(stack.isEmpty())
            return false;

        Iterator<MenuComponent> iterator = stack.peek();
        if(!iterator.hasNext()) {
            stack.pop();
            return hasNext();
        }

        return true;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
