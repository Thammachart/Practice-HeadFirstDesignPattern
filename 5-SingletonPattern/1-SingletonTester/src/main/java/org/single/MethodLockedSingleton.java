package org.single;

public class MethodLockedSingleton {
    private static MethodLockedSingleton instance;

    public static synchronized MethodLockedSingleton getHugeOverheadInstance() {
        if(instance == null) {
            instance = new MethodLockedSingleton();
        }

        return instance;
    }

    private MethodLockedSingleton() {}

    public String getFullClassName() {
        return this.getClass().getName();
    }
}
