package org.diner.menus;

import java.util.Iterator;

import org.diner.menus.menuitems.MenuItem;

/**
 * @deprecated
 * java.lang.Iterable<MenuItem> can be used to substitute this
 */
@Deprecated
public interface Menu {
    public Iterator<MenuItem> createIterator();
}
