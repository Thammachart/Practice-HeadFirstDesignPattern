package org.test.diner;

import java.util.Arrays;

import org.junit.Test;

import org.diner.Waiter;

import org.diner.menus.PancakeHouseMenu;
import org.diner.menus.DinerMenu;
import org.diner.menus.CafeMenu;

public class MenuTest {

    @Test
    public void menuIterationTest() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();

        Waiter waiter = new Waiter(Arrays.asList(pancakeHouseMenu, dinerMenu, cafeMenu));
        waiter.printMenu();
    }
}
