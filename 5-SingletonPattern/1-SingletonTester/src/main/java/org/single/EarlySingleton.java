package org.single;

public class EarlySingleton {
    private static EarlySingleton instance;

    static {
        instance = new EarlySingleton();
    }

    public static EarlySingleton getEarlyInstance() {
        return instance;
    }

    private EarlySingleton() {}

    public String getFullClassName() {
        return this.getClass().getName();
    }
}
