package org.test.starbuzz;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.junit.Test;

import org.starbuzz.Util;
import org.starbuzz.beverage.template.hook.*;

public class StarBuzzTest {
    private InputStream getInputStreamFromString(String string) {
        return new ByteArrayInputStream( string.getBytes() );
    }

    @Test
    public void testTeaWithHook() {
        InputStream inputStream = getInputStreamFromString("yes");
        Util util = new Util(inputStream);

        TeaWithHook tea = new TeaWithHook(util);
        System.out.println("\nMaking Tea...");
        tea.prepareRecipe();
    }

    @Test
    public void testCoffeeWithHook() {
        InputStream inputStream = getInputStreamFromString("yes");
        Util util = new Util(inputStream);

        CoffeeWithHook coffee = new CoffeeWithHook(util);
        System.out.println("\nMaking Coffee...");
        coffee.prepareRecipe();
    }
}
