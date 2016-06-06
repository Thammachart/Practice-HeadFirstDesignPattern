package org.diner;

import org.diner.menus.MenuComponent;
import org.diner.menus.menuitems.MenuItem;

public class Waiter {
    private MenuComponent rootMenuComponent;

    public Waiter(MenuComponent rootMenuComponent) {
        this.rootMenuComponent = rootMenuComponent;
    }

    public void printMenu() {
        rootMenuComponent.print();
    }

    public void printVegetarianMenu() {
        for(MenuComponent menuComponent : rootMenuComponent) {
            if(!(menuComponent instanceof MenuItem))
                continue;

            MenuItem menuItem = (MenuItem)menuComponent;
            if(menuItem.isVegetarian())
                menuItem.print();
        }
    }
}
