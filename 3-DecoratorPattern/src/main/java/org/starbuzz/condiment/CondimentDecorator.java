package org.starbuzz.condiment;

import org.starbuzz.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    
    @Override
    public abstract String getDescription();
}
