package by.epam.nickgrudnitsky.service;


import java.util.ArrayList;
import java.util.List;

import static by.epam.nickgrudnitsky.util.DataInput.readMenuNumber;

public class AlgorithmService {

    private static List<String> startupMenu = new ArrayList<>();

    static {
        startupMenu.add("1 - Monty Hall problem.");
        startupMenu.add("2 - Birthday problem.");
        startupMenu.add("3 - Marriage problem.");
        startupMenu.add("0 - Exit program.");
    }

    public static void runProgram() {
        outputMenuToConsole(startupMenu);
        process(readMenuNumber());
    }

    private static void process(int menuItem) {
        switch (menuItem) {
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 0: {
                break;
            }
            default: {
                runProgram();
            }
        }
    }

    private static void outputMenuToConsole(List<String> startupMenu) {
        System.out.println("Enter a number to continue:");
        for (String menuItem : startupMenu) {
            System.out.println(menuItem);
        }
    }

}
