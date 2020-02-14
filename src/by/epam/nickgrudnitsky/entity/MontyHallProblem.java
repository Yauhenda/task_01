package by.epam.nickgrudnitsky.entity;


import by.epam.nickgrudnitsky.util.Validator;

import java.util.Random;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.validateNumberOfChecks;

public class MontyHallProblem extends Problem {
    private boolean chosenDoor;
    private int numberOfChecks;
    private int numberOfWinningsWhenChangeChoice = 0;
    private int numberOfWinningsWhenDoNotChangeChoice = 0;
    private static Random random = new Random();
    private final static int DOORS = 3;

    public void checkAlgorithm() {
        printIntroduction();

        numberOfChecks = readNumber();

        if (validateNumberOfChecks(numberOfChecks)) {
            runCheck();
        } else {
            printValidationFailure();
            checkAlgorithm();
        }
    }

    public MontyHallProblem() {
        setName("Monty Hall problem.");
    }

    private void runCheck() {
        for (int i = 0; i < numberOfChecks; i++) {

            chooseDoor();

            if (chosenDoor) {
                numberOfWinningsWhenDoNotChangeChoice++;
            } else {
                numberOfWinningsWhenChangeChoice++;
            }
        }

        printResults();

        numberOfWinningsWhenChangeChoice = 0;
        numberOfWinningsWhenDoNotChangeChoice = 0;
    }

    private void chooseDoor() {
        chosenDoor = random.nextInt(DOORS) + 1 == 1;
    }

    private void printIntroduction() {
        System.out.println("Enter the number of checks.");
    }

    private void printValidationFailure() {
        System.out.printf("The number of checks must be between %d and %d.\n",
                Validator.MIN_NUMBER_OF_CHECKS, Validator.MAX_NUMBER_OF_CHECKS);
    }

    private void printResults() {
        System.out.printf("Wins out of %d:\n   when changing choices - %d.\n   when do not changing choices - %d.\n",
                numberOfChecks, numberOfWinningsWhenChangeChoice, numberOfWinningsWhenDoNotChangeChoice);
    }
}
