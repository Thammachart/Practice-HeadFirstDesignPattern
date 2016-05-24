package org.starbuzz;

import java.util.Scanner;
import java.io.InputStream;

public final class Util {
    private InputStream inputStream;

    public Util() {
        this(System.in);
    }

    public Util(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }

    public boolean parseAnswer(String input) {
        input = input.toLowerCase();
        return input.startsWith("y");
    }
}
