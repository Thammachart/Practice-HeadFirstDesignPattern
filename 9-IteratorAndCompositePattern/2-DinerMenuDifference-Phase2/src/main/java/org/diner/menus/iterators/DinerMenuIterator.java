package org.diner.menus.iterators;

import org.diner.menus.menuitems.MenuItem;

/**
 * @deprecated
 * Implementation of deprecated Iterator interface
 */
@Deprecated
public class DinerMenuIterator implements Iterator {

    private int currentIndex;
    private MenuItem[] menuItems;

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
}
