package by.epam.nickgrudnitsky.service;


import by.epam.nickgrudnitsky.entity.BirthdayProblem;
import by.epam.nickgrudnitsky.entity.MarriageProblem;
import by.epam.nickgrudnitsky.entity.MontyHallProblem;
import by.epam.nickgrudnitsky.entity.Problem;

import java.util.HashMap;
import java.util.Map;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.validateMenuItem;

public class AlgorithmService {
    private Map<Integer, Problem> startupMenu = new HashMap<>();

    public AlgorithmService() {
        startupMenu.put(1, new MontyHallProblem());
        startupMenu.put(2, new BirthdayProblem());
        startupMenu.put(3, new MarriageProblem());
    }

    public void runProgram() {
        int menuItem;

        outputMenuToConsole(startupMenu);

        menuItem = readNumber();

        if (validateMenuItem(menuItem)) {
            process(menuItem);
        } else {
            printMenuValidationFailure();
            runProgram();
        }
    }

    private void process(int menuItem) {
        if (menuItem == 0) {
            return;
        }
        startupMenu.get(menuItem).checkAlgorithm();
        runProgram();
    }

    private void outputMenuToConsole(Map<Integer, Problem> startupMenu) {
        System.out.println("Enter a number to continue:");

        for (Map.Entry<Integer, Problem> problem : startupMenu.entrySet()) {
            System.out.println(problem.getKey() + " - " + problem.getValue().getName());
        }

        System.out.println("0 - Exit.");
    }

    private void printMenuValidationFailure() {
        System.out.println("Choose from the given numbers.");
    }
}
