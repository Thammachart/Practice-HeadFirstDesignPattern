package org.diner.menus;

import java.util.ArrayList;
import java.util.Iterator;

import org.diner.menus.menuitems.MenuItem;

public class PancakeHouseMenu implements Iterable<MenuItem> {
    private ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();

        addItem("K&B Pancake Breakfast","Just Pancake",true,2.99);
        addItem("Regular Pancake Breakfast","Another Pancake with eggs for you",false,2.99);
        addItem("Blueberry Pancake","Pancake with Blueberry!",true,3.49);
        addItem("Waffles","Waffles with Strawberries or Blueberries",true,3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.iterator();
    }
}
