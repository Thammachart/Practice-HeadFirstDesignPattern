package org.diner;

import java.util.Iterator;

import org.diner.menus.menuitems.MenuItem;

public class Waiter {
    private Iterable<MenuItem> pancakeHouseMenu;
    private Iterable<MenuItem> dinerMenu;

    public Waiter(Iterable<MenuItem> pancakeHouseMenu, Iterable<MenuItem> dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeHouseMenu);
        System.out.println("\nLUNCH");
        printMenu(dinerMenu);
    }

    public void printMenu(Iterable<MenuItem> menu) {
        for(MenuItem menuItem : menu) {
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

}
