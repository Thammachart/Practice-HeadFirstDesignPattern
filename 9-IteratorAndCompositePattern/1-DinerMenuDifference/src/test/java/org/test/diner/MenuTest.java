package org.test.diner;

import org.junit.Test;

import org.diner.Waiter;

import org.diner.menus.PancakeHouseMenu;
import org.diner.menus.DinerMenu;

public class MenuTest {

    @Test
    public void menuIterationTest() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waiter waiter = new Waiter(pancakeHouseMenu, dinerMenu);
        waiter.printMenu();
    }
}
