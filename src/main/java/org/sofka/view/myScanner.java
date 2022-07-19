package org.sofka.view;

import java.util.Scanner;

public class myScanner {

    protected final Scanner scanner = new Scanner(System.in);
    private static myScanner instance = null;

    public static myScanner getInstance() {
        if (instance instanceof myScanner) {
            return instance;
        } else {
            instance = new myScanner();
        }
        return instance;
    }

    public Integer getInteger() {
        return Integer.parseInt(scanner.nextLine());
    }

    public Double getDouble() {
        return Double.parseDouble(scanner.nextLine());
    }

    public String getString() {
        return scanner.nextLine().replace("\\n", "");
    }

}
