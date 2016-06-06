package org.diner.menus;

import java.util.Iterator;

public interface MenuComponent extends Iterable<MenuComponent>{
    String getName();
    String getDescription();

    void print();

    Iterator<MenuComponent> iterator();
}
