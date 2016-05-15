package org.home.device;

public class Light extends Device {

    public Light() {
        super();
    }

    public Light(String name) {
        super(name);
    }

    public void on() {
        System.out.println(name + " Light is on");
    }

    public void off() {
        System.out.println(name + " Light is off");
    }
}
