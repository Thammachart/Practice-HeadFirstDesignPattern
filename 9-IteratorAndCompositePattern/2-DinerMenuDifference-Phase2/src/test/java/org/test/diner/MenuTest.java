package org.test.diner;

import java.util.Arrays;

import org.junit.Test;

import org.diner.Waiter;

import org.diner.menus.MenuComponent;
import org.diner.menus.Menu;
import org.diner.menus.menuitems.MenuItem;

public class MenuTest {

    @Test
    public void compositeMenusTest() {
        Menu pancake = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        Menu diner = new Menu("DINER MENU", "Lunch");
        Menu cafe = new Menu("CAFE MENU", "Dinner");
        Menu dessert = new Menu("DESSERT MENU", "Dessert of course!");

        Menu allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.addAll(Arrays.asList(pancake, diner, cafe));

        pancake.addAll(Arrays.asList(
            new MenuItem("K&B Pancake Breakfast","Just Pancake",true,2.99),
            new MenuItem("Regular Pancake Breakfast","Another Pancake with eggs for you",false,2.99),
            new MenuItem("Blueberry Pancake","Pancake with Blueberry!",true,3.49),
            new MenuItem("Waffles","Waffles with Strawberries or Blueberries",true,3.59)
        ));

        diner.addAll(Arrays.asList(
            new MenuItem("Vegetarian BLT","(Fakin') Bacon with lettuce & tomato",true,2.99),
            new MenuItem("BLT","Bacon with lettuce & tomato",false,2.99),
            new MenuItem("Soup of the day","Soup with Potato Salad",false,3.29),
            new MenuItem("Hotdog","Just hot dog...",false,3.05),
            new MenuItem("Pasta","Spaghetti with Marinara",true,3.89),
            dessert
        ));

        cafe.addAll(Arrays.asList(
            new MenuItem("Veggie Burger and Air Fried","Just a Veggie Burger and another Air Fried",true,3.99),
            new MenuItem("Soup of the day","Soup with Salad",false,3.69),
            new MenuItem("Burrito","A large Burrito",true,4.29)
        ));

        dessert.addAll(Arrays.asList(
            new MenuItem("Apple Pie","Apple pie with a flakey crust",true,1.59),
            new MenuItem("Cheese Cake","Creamy New York Cheesecake",true,1.99),
            new MenuItem("Sorbet","A scoop of raspberry and a scoop of lime",true,1.89)
        ));

        Waiter waiter = new Waiter(allMenus);
        waiter.printMenu();
    }
}
