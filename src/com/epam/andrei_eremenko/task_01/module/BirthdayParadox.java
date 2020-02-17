package com.epam.andrei_eremenko.task_01.module;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;
import java.util.function.Supplier;

public class BirthdayParadox extends Paradox {

    private static final short QUANTITY_OF_TRIES = 1000;
    private static final short QUANTITY_OF_HUMANS = 23;
    private static final short DAYS = 365;
    private static short[][] array = new short
            [BirthdayParadox.QUANTITY_OF_TRIES]
            [BirthdayParadox.QUANTITY_OF_HUMANS];
    private static short frequencies = 0;
    private static Random rand = new Random();

    public BirthdayParadox() {
        super("Birthday paradox");
    }

    private Supplier<String> supplier = () -> {
        Formatter formatter = new Formatter();
        formatter.format("In groups of %d people, birthdays matches " +
                        "quantity of birthday matches for two or more people " +
                        "is %d cases.%nQuantity of checked groups is %d",
                QUANTITY_OF_HUMANS, frequencies, QUANTITY_OF_TRIES);
        return formatter.toString();
    };

    private static void playAlgorithm(short[][] array) {
        createGroups(array);
        sortHumansByBirthday(array);
        calculateProbability(array);
    }

    private static void createGroups(short[][] array) {

        for (short i = 0; i < array.length; i++) {

            for (short j = 0; j < array[i].length; j++) {
                array[i][j] = (short) (rand.nextInt(BirthdayParadox.DAYS) + 1);
            }
        }
    }

    private static void sortHumansByBirthday(short[][] array) {

        for (short[] shorts : array) {
            Arrays.sort(shorts);
        }
    }

    private static void calculateProbability(short[][] array) {

        for (short[] shorts : array) {
            int temp = shorts[0];

            for (int j = 1; j < shorts.length; j++) {

                if (shorts[j] == temp) {
                    BirthdayParadox.frequencies++;
                    break;
                }
                temp = shorts[j];
            }
        }
    }

    @Override
    public String getResult() {
        playAlgorithm(array);
        return supplier.get();
    }

    @SuppressWarnings("all")
    public static void resetVariables() {
        frequencies = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 0;
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
