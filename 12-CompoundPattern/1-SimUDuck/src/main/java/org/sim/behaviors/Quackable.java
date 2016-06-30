package org.sim.behaviors;

import org.sim.observers.QuackObservable;

public interface Quackable extends QuackObservable {
    void quack();
}
