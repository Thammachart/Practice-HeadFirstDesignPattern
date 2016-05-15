package org.home.device;

public class GarageDoor extends Device {

    public GarageDoor() {
        super();
    }

    public GarageDoor(String name) {
        super(name);
    }

    public void up() {
        System.out.println(name + " Garage Door is up");
    }

    public void down() {
        System.out.println(name + " Garage Door is down");
    }

    public void stop() {
        System.out.println(name + " Garage Door is stopped");
    }

    public void lightOn() {
        System.out.println(name + " Garage Door Light is on");
    }

    public void lightOff() {
        System.out.println(name + "Garage Door Light is off");
    }
}
