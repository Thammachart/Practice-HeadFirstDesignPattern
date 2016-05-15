package org.home.device;

public class Stereo extends Device {

    public Stereo() {
        super();
    }

    public Stereo(String name) {
        super(name);
    }

    public void on() {
        System.out.println(name + " Stereo is on");
    }

    public void off() {
        System.out.println(name + " Stereo is off");
    }

    public void setCD() {
        System.out.println(name + " Stereo CD is set!");
    }

    public void setDVD() {
        System.out.println(name + " Stereo DVD is set!");
    }

    public void setRadio() {
        System.out.println(name + " Stereo Radio is set!");
    }

    public void setVolume(int volume) {
        System.out.println(name + " Stereo Volume is set to " + volume);
    }
}
