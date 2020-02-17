package com.epam.andrei_eremenko.task_01.module;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;
import java.util.function.Supplier;

public class OptimalStoppingParadox extends Paradox {

    private static final int QUANTITY_OF_GROOMS = 100;
    private static final int STEP = 10;
    private static final int QUANTITY_OF_TRIES = 1000;
    private static int[] grooms = new int[OptimalStoppingParadox.QUANTITY_OF_GROOMS];
    private static int[] ratesAmount = new int[OptimalStoppingParadox.STEP - 1];
    private static double[] averageRates = new double[ratesAmount.length];
    private static Random rand = new Random();

    public OptimalStoppingParadox() {
        super("Optimal stopping paradox");
    }

    private Supplier<String> supplier = () -> {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        for (int i = 0; i < averageRates.length; i++) {
            int temp = 1;
            formatter.format("With a step of %d average rate is %5.2f%n",
                    STEP * (temp + i), averageRates[i]);
        }
        formatter.format("Tries quantity is %d%n", QUANTITY_OF_TRIES);
        formatter.format("Grooms quantity is %d", QUANTITY_OF_GROOMS);
        return formatter.toString();
    };

    private static void playAlgorithm() {
        calculateRates(OptimalStoppingParadox.grooms, OptimalStoppingParadox.ratesAmount);
        calculateAverageRates(OptimalStoppingParadox.ratesAmount,
                OptimalStoppingParadox.averageRates);
    }

    private static void addNewGrooms(int[] grooms) {

        for (int i = 0; i < grooms.length; i++) {
            grooms[i] = rand.nextInt(OptimalStoppingParadox.QUANTITY_OF_GROOMS) + 1;
        }
    }

    private static int findTeBestGroomFromFirstInterval(int[] grooms, int nextStep) {
        int theBestGroom = grooms[0];

        for (int i = 0; i < nextStep; i++) {

            if (grooms[i] > theBestGroom) {
                theBestGroom = grooms[i];
            }
        }
        return theBestGroom;
    }

    private static void sumRates(int[] grooms, int[] ratesAmount) {
        int flag = 0;
        int nextStep = OptimalStoppingParadox.STEP;

        while (nextStep < OptimalStoppingParadox.QUANTITY_OF_GROOMS) {
            if (flag > ratesAmount.length - 1) {
                break;
            }
            int temp = findTeBestGroomFromFirstInterval(grooms, nextStep);

            for (int i = nextStep; i < grooms.length; i++) {

                if (grooms[i] > temp) {
                    ratesAmount[flag] += grooms[i];
                    flag++;
                    break;
                } else if (i == grooms.length - 1) {
                    flag++;
                }
            }
            nextStep += OptimalStoppingParadox.STEP;
        }
    }

    private static void calculateRates(int[] grooms, int[] ratesAmount) {

        for (int i = 0; i < OptimalStoppingParadox.QUANTITY_OF_TRIES; i++) {
            addNewGrooms(grooms);
            sumRates(grooms, ratesAmount);
        }
    }

    private static void calculateAverageRates(int[] ratesAmount, double[] averageRates) {

        for (int i = 0; i < ratesAmount.length; i++) {
            averageRates[i] = (double) ratesAmount[i] /
                    (double) OptimalStoppingParadox.QUANTITY_OF_TRIES;
        }
    }

    public static void resetVariables() {
        Arrays.fill(grooms, 0);
        Arrays.fill(ratesAmount, 0);
        Arrays.fill(averageRates, 0);
    }

    @Override
    public String getResult() {
        playAlgorithm();
        return supplier.get();
    }

    @Override
    public String toString() {
        return getName();
    }
}


