package org.diner.menus.menuitems;

import org.diner.menus.MenuComponent;
import org.diner.menus.iterators.NullIterator;

import java.util.Iterator;

public class MenuItem implements MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.print("  " + getName());
        if(isVegetarian())
            System.out.print("(v)");
        System.out.println(", " + getPrice());
        System.out.println("    -- " + getDescription());
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        return new NullIterator();
    }
}
