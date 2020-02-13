package by.epam.nickgrudnitsky.service;


import by.epam.nickgrudnitsky.entity.MontyHallProblem;
import by.epam.nickgrudnitsky.entity.Problem;

import java.util.ArrayList;
import java.util.List;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.validateMenuItem;

public class AlgorithmService {
    private List<String> startupMenu = new ArrayList<>();

     {
        startupMenu.add("1 - Monty Hall problem.");
        startupMenu.add("2 - Birthday problem.");
        startupMenu.add("3 - Marriage problem.");
        startupMenu.add("0 - Exit program.");
    }

    public void runProgram() {
        int menuItem;

        outputMenuToConsole(startupMenu);
        menuItem = readNumber();
        if (validateMenuItem(menuItem)){
            process(menuItem);
        } else {
            printMenuValidationFailure();
            runProgram();
        }
    }

    private void runAlgorithm(Problem problem) {
        problem.checkAlgorithm();
    }

    private void process(int menuItem) {
        switch (menuItem) {
            case 1: {
                runAlgorithm(new MontyHallProblem());
                runProgram();
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

    private void outputMenuToConsole(List<String> startupMenu) {
        System.out.println("Enter a number to continue:");
        for (String menuItem : startupMenu) {
            System.out.println(menuItem);
        }
    }

    private void printMenuValidationFailure() {
        System.out.println("Choose from the given numbers.");
    }
}
