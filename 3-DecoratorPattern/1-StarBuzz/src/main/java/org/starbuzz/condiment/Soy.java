package org.starbuzz.condiment;

import org.starbuzz.beverage.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double price = beverage.cost();
        switch (this.getSize()) {
            case TALL:
                price += 0.10;
            break;
            case GRANDE:
                price += 0.15;
            break;
            case VENTI:
                price += 0.20;
            break;
        }
        return price;
    }
}
