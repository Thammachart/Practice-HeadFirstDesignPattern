package org.diner.menus;

import java.util.HashMap;
import java.util.Iterator;

import org.diner.menus.menuitems.MenuItem;

public class CafeMenu implements Iterable<MenuItem> {
    private HashMap<String, MenuItem> menuItems;

    public CafeMenu() {
        menuItems = new HashMap<>();

        addItem("Veggie Burger and Air Fried","Just a Veggie Burger and another Air Fried",true,3.99);
        addItem("Soup of the day","Soup with Salad",false,3.69);
        addItem("Burrito","A large Burrito",true,4.29);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(name,menuItem);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.values().iterator();
    }
}
