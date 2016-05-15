package org.home.device;

public class CeilingFan extends Device {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    int speed;

    public CeilingFan() {
        super();
    }

    public CeilingFan(String name) {
        super(name);
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println(name + " Ceiling Fan is set to high");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(name + " Ceiling Fan is set to medium");
    }

    public void low() {
        speed = LOW;
        System.out.println(name + " Ceiling Fan is set to low");
    }

    public void off() {
        speed = OFF;
        System.out.println(name + " Ceiling Fan is off");
    }

    public int getSpeed() {
        return speed;
    }
}
