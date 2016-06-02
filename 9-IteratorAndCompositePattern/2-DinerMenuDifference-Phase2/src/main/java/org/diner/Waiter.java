package org.diner;

import java.util.Iterator;
import java.util.List;

import org.diner.menus.menuitems.MenuItem;

public class Waiter {
    private List<Iterable<MenuItem>> menus;

    public Waiter(List<Iterable<MenuItem>> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        for(Iterable<MenuItem> menu : menus) {
            printMenu(menu);
        }
    }

    private void printMenu(Iterable<MenuItem> menu) {
        for(MenuItem menuItem : menu) {
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

}
