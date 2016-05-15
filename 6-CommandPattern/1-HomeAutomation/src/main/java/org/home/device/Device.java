package org.home.device;

public abstract class Device {
    protected String name;

    public Device() {
        this.name = "";
    }

    public Device(String name) {
        this.name = name;
    }
}
