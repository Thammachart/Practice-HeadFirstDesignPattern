package org.single;

public class SingletonTester {
    public static void main(String args[]) {
        ClassicSingleton classicSingleton = ClassicSingleton.getInstance();
        MethodLockedSingleton methodLockedSingleton = MethodLockedSingleton.getHugeOverheadInstance();
        DoubleCheckLockedSingleton doubleCheckLockedSingleton = DoubleCheckLockedSingleton.getLessOverheadInstance();
        EarlySingleton earlySingleton = EarlySingleton.getEarlyInstance();

        System.out.println(classicSingleton.getFullClassName());
        System.out.println(methodLockedSingleton.getFullClassName());
        System.out.println(doubleCheckLockedSingleton.getFullClassName());
        System.out.println(earlySingleton.getFullClassName());
    }
}
