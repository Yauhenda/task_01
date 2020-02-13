package by.epam.nickgrudnitsky.entity;


import by.epam.nickgrudnitsky.util.Validator;

import java.util.Random;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.validateNumberOfChecks;

public class MontyHallProblem implements Problem {
    private static Random random = new Random();
    private boolean door1;
    private boolean door2;
    private boolean door3;
    private boolean chosenDoor;
    private int numberOfChecks;
    private int numberOfWinningsWhenChangeChoice = 0;
    private int numberOfWinningsWhenDoNotChangeChoice = 0;

    @Override
    public void checkAlgorithm() {
        printIntroduction();
        numberOfChecks = readNumber();
        if (validateNumberOfChecks(numberOfChecks)) {
            runCheck(numberOfChecks);
        } else {
            printValidationFailure();
            checkAlgorithm();
        }

    }

    private void runCheck(int numberOfChecks) {
        for (int i = 0; i < numberOfChecks; i++) {
            fillDoors();
            chooseDoor();
            if (chosenDoor) {
                numberOfWinningsWhenDoNotChangeChoice++;
            } else {
                numberOfWinningsWhenChangeChoice++;
            }
        }
        printResults();
    }

    private void chooseDoor() {
        switch (randomDoor()) {
            case 1: {
                chosenDoor = door1;
                break;
            }
            case 2: {
                chosenDoor = door2;
                break;
            }
            case 3: {
                chosenDoor = door3;
                break;
            }
        }
    }

    private int randomDoor() {
        return (random.nextInt(3) + 1);
    }

    private void fillDoors() {
        switch (randomDoor()) {
            case 1: {
                door1 = true;
                door2 = false;
                door3 = false;
                break;
            }
            case 2: {
                door1 = false;
                door2 = true;
                door3 = false;
                break;
            }
            case 3: {
                door1 = false;
                door2 = false;
                door3 = true;
                break;
            }
        }
    }

    private void printIntroduction() {
        System.out.println("Enter the number of checks.");
    }

    private void printValidationFailure() {
        System.out.printf("The number of checks must be between %d and %d.\n", Validator.MIN_NUMBER_OF_CHECKS, Validator.MAX_NUMBER_OF_CHECKS);
    }

    private void printResults() {
        System.out.printf("Wins out of %d:\n   when changing choices - %d.\n   when do not changing choices - %d.\n",
                numberOfChecks, numberOfWinningsWhenChangeChoice, numberOfWinningsWhenDoNotChangeChoice);
    }

}
