package org.test.sim;

import org.junit.Test;

import org.sim.duck.Duck;
import org.sim.duck.MallardDuck;

import org.sim.turkey.Turkey;
import org.sim.turkey.WildTurkey;
import org.sim.turkey.adapter.TurkeyAsDuckAdapter;

public class SimUDuckTest {

    private void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

    @Test
    public void MallardDuckAndWildTurkey_LivingInHarmory() {
        Duck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();
        Duck turkeyAsDuckAdapter = new TurkeyAsDuckAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\n");
        System.out.println("The Duck says...");
        testDuck(duck);

        System.out.println("\n");
        System.out.println("The TurkeyAsDuckAdapter says...");
        testDuck(turkeyAsDuckAdapter);
    }
}
