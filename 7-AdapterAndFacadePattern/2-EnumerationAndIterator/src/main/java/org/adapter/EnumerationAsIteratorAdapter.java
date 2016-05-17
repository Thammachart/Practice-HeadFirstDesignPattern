package org.adapter;

import java.util.Iterator;
import java.util.Enumeration;

public class EnumerationAsIteratorAdapter<E> implements Iterator<E> {
    Enumeration<E> enumeration;

    public EnumerationAsIteratorAdapter(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This Implementation does not support 'remove' functionality");
    }
}
