package by.epam.nickgrudnitsky.entity;

import by.epam.nickgrudnitsky.util.Validator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.validateNumberOfChecks;
import static by.epam.nickgrudnitsky.util.Validator.validateNumberOfPeople;

public class BirthdayProblem implements Problem {
    private final static int DAYS_IN_A_YEAR = 365;
    private static Random random = new Random();
    private int numberOfPeople;
    private int numberOfChecks;
    private int numberOfCoincidences;
    private Set<Integer> birthdays = new HashSet<>();


    @Override
    public void checkAlgorithm() {
        printIntroduction();
        numberOfPeople = readNumber();
        numberOfChecks = readNumber();
        if (validateNumberOfPeople(numberOfPeople) && validateNumberOfChecks(numberOfChecks)) {
            runCheck();
        } else {
            printValidationFailure();
            checkAlgorithm();
            return;
        }
        printResults();
    }

    private void runCheck() {
        for (int i = 0; i < numberOfChecks; i++) {
            fillBirthdays();

            if (birthdays.size() < numberOfPeople) {
                numberOfCoincidences++;
            }
            birthdays.clear();
        }
    }

    private void fillBirthdays() {
        for (int i = 0; i < numberOfPeople; i++) {
            birthdays.add(random.nextInt(DAYS_IN_A_YEAR) + 1);
        }
    }

    private void printIntroduction() {
        System.out.println("Enter the number of people and then number of checks.");
    }

    private void printResults() {
        System.out.printf("Birthdays coincided %d times with the number of people equal to %d and " +
                "the number of iterations %d.\n", numberOfCoincidences, numberOfPeople, numberOfChecks);
    }

    private void printValidationFailure() {
        System.out.printf("The number of people must be between %d and %d.\n", Validator.MIN_NUMBER_OF_PEOPLE, Validator.MAX_NUMBER_OF_PEOPLE);
        System.out.printf("The number of checks must be between %d and %d.\n", Validator.MIN_NUMBER_OF_CHECKS, Validator.MAX_NUMBER_OF_CHECKS);
    }
}
