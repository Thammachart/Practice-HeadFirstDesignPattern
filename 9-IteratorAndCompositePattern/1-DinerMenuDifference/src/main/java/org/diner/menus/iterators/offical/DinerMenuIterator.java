package org.diner.menus.iterators.official;

import java.util.Iterator;

import org.diner.menus.menuitems.MenuItem;

public class DinerMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] menuItems;
    private int currentIndex;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.currentIndex = 0;
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < menuItems.length && menuItems[currentIndex] != null;
    }

    @Override
    public MenuItem next() {
        return menuItems[currentIndex++];
    }

    @Override
    public void remove() {
        if(currentIndex <= 0) {
            throw new IllegalStateException("At least one 'next()' call must be made");
        }
        if(menuItems[currentIndex-1] != null) {
            for(int i = currentIndex-1; i < (menuItems.length-1); i++) {
                menuItems[i] = menuItems[i+1];
            }
            menuItems[menuItems.length-1] = null;
        }
    }
}
