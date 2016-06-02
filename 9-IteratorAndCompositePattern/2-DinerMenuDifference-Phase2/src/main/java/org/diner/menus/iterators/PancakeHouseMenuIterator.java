package org.diner.menus.iterators;

import java.util.ArrayList;

import org.diner.menus.menuitems.MenuItem;

/**
 * @deprecated
 * Implementation of deprecated Iterator interface
 */
@Deprecated
public class PancakeHouseMenuIterator implements Iterator {
    private int currentIndex;
    private ArrayList<MenuItem> menuItems;

    public PancakeHouseMenuIterator(ArrayList<MenuItem> menuItems) {
        this.currentIndex = 0;
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < menuItems.size();
    }

    @Override
    public MenuItem next() {
        return menuItems.get(currentIndex++);
    }
}
