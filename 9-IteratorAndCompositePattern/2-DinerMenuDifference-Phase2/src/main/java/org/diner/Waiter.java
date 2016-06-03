package org.diner;

import org.diner.menus.MenuComponent;

public class Waiter {
    private MenuComponent rootMenuComponent;

    public Waiter(MenuComponent rootMenuComponent) {
        this.rootMenuComponent = rootMenuComponent;
    }

    public void printMenu() {
        rootMenuComponent.print();
    }
}
