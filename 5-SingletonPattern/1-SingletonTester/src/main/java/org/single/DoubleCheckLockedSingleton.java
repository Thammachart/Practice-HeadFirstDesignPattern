package org.single;

public class DoubleCheckLockedSingleton {
    private static volatile DoubleCheckLockedSingleton instance;

    public static DoubleCheckLockedSingleton getLessOverheadInstance() {
        if(instance == null) {
            synchronized (DoubleCheckLockedSingleton.class) {
                if(instance == null) {
                    instance = new DoubleCheckLockedSingleton();
                }
            }
        }

        return instance;
    }

    private DoubleCheckLockedSingleton() {}

    public String getFullClassName() {
        return this.getClass().getName();
    }
}
