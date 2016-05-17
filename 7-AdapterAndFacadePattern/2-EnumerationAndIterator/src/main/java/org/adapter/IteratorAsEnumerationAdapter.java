package org.adapter;

import java.util.Iterator;
import java.util.Enumeration;

public class IteratorAsEnumerationAdapter<E> implements Enumeration<E> {
    Iterator<E> iterator;

    public IteratorAsEnumerationAdapter(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public E nextElement() {
        return iterator.next();
    }
}
