package by.epam.nickgrudnitsky.entity;

import by.epam.nickgrudnitsky.util.Validator;

import java.util.*;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.*;

public class MarriageProblem extends Problem {
    private int numberOfFiances;
    private int numberOfChecks;
    private int numberOfCorrectChoices;
    private List<Integer> fiances = new ArrayList<>();

    public MarriageProblem() {
        setName("Marriage problem.");
    }

    public void checkAlgorithm() {
        printIntroduction();
        numberOfFiances = readNumber();
        numberOfChecks = readNumber();
        if (validateNumberOfFiance(numberOfFiances) && validateNumberOfChecks(numberOfChecks)) {
            runCheck();
        } else {
            printValidationFailure();
            checkAlgorithm();
            return;
        }
        printResults();
        numberOfCorrectChoices = 0;
    }

    private void runCheck() {
        int chosenFiance = 0;
        int fianceQuality = 0;
        double step = Math.round(numberOfFiances / Math.exp(1));
        fillFiances();

        for (int i = 0; i < numberOfChecks; i++) {

            Collections.shuffle(fiances);

            for (int j = 0; j < numberOfFiances; j++) {
                int fiance = fiances.get(j);
                if (fianceQuality < fiance) {
                    if (j >= step){
                        chosenFiance = fiance;
                        break;
                    }
                    fianceQuality = fiance;
                }
            }

            if (chosenFiance == numberOfFiances) {
                numberOfCorrectChoices++;
            }

            fianceQuality = 0;
            chosenFiance = 0;
        }
    }

    private void fillFiances() {
        for (int i = 1; i <= numberOfFiances; i++) {
            fiances.add(i);
        }
    }

    private void printIntroduction() {
        System.out.println("Enter the number of fiances and then number of checks.");
    }

    private void printResults() {
        System.out.printf("The best fiance out of %d was selected %d times in %d attempts in increments of 1/e.\n",
                numberOfFiances, numberOfCorrectChoices, numberOfChecks);
    }

    private void printValidationFailure() {
        System.out.printf("The number of fiances must be between %d and %d.\n",
                MIN_NUMBER_OF_FIANCES, MAX_NUMBER_OF_FIANCES);
        System.out.printf("The number of checks must be between %d and %d.\n",
                Validator.MIN_NUMBER_OF_CHECKS, Validator.MAX_NUMBER_OF_CHECKS);
    }
}
