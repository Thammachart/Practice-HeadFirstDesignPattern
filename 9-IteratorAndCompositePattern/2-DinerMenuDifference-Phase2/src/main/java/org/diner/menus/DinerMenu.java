package org.diner.menus;

import java.util.Iterator;

import org.diner.menus.menuitems.MenuItem;

import org.diner.menus.iterators.official.DinerMenuIterator;

public class DinerMenu implements Iterable<MenuItem> {
    public static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT","(Fakin') Bacon with lettuce & tomato",true,2.99);
        addItem("BLT","Bacon with lettuce & tomato",false,2.99);
        addItem("Soup of the day","Soup with Potato Salad",false,3.29);
        addItem("Hotdog","Just hot dog...",false,3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems++] = menuItem;
        }
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new DinerMenuIterator(menuItems);
    }
}
