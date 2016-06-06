package org.diner.menus;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.diner.menus.iterators.CompositeIterator;

public class Menu implements MenuComponent {
    private List<MenuComponent> menuComponents;
    private Iterator<MenuComponent> iterator;

    private String name;
    private String description;

    public Menu(String name, String description) {
        this.menuComponents = new ArrayList<>();

        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void addAll(Collection<MenuComponent> collection) {
        menuComponents.addAll(collection);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("----------------------");

        for(MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        if(iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }

        return iterator;
    }
}
