package org.single;

public class ClassicSingleton {
    private static ClassicSingleton instance;

    public static ClassicSingleton getInstance() {
        if (instance == null) {
            instance = new ClassicSingleton();
        }

        return instance;
    }

    private ClassicSingleton() {}

    public String getFullClassName() {
        return this.getClass().getName();
    }
}
