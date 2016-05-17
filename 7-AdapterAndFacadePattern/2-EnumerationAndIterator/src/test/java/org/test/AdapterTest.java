package org.test;

import org.junit.Test;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;
import java.util.Enumeration;

import org.adapter.EnumerationAsIteratorAdapter;
import org.adapter.IteratorAsEnumerationAdapter;

public class AdapterTest {

    private void fillCollection(Collection<String> collection) {
        collection.add("TestString1");
        collection.add("ABCDEFG");
        collection.add("TestString2");
        collection.add("AGHJKL");
        collection.add("TestString3");
    }

    @Test
    public void testEnumerationAsIterator() {
        Vector<String> testVector = new Vector<>();
        fillCollection(testVector);

        Iterator<String> iterator = new EnumerationAsIteratorAdapter<>(testVector.elements());

        System.out.println("First element is " + iterator.next());
        try {
            System.out.println("Trying to remove the first element...");
            iterator.remove();
        } catch(UnsupportedOperationException e) {
            System.err.println("Expected Error: " + e.getMessage());
        }
        while(iterator.hasNext()){
            System.out.println("Next element is " + iterator.next());
        }
    }

    @Test
    public void testIteratorAsEnumeration() {
        ArrayList<String> testArrayList = new ArrayList<>();
        fillCollection(testArrayList);

        Enumeration<String> enumeration = new IteratorAsEnumerationAdapter<>(testArrayList.iterator());

        while(enumeration.hasMoreElements()) {
            System.out.println("Next Elemet is " + enumeration.nextElement());
        }
    }
}
