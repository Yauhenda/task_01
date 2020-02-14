package com.epam;

import java.util.Random;

public class LegibleBride {

    public static final int COUNT_OF_GROOM = 100;

    public static void legibleBrideAlgorithm() {
        int choiceOfBride;
        double betterChoice;
        for (int i = 10; i < COUNT_OF_GROOM; i += 10) {
            betterChoice = 0;
            for (int j = 0; j < 100000; j++) {
                choiceOfBride = findBetterEndRating(createGroomsRating(), findBetterBeginRating(createGroomsRating(), i));
                betterChoice += checkChoiceBride(createGroomsRating(), choiceOfBride);
            }
            System.out.println(betterChoice);
            printResult(i, betterChoice / 100000);
        }
    }

    public static int[] createGroomsRating() {
        int[] groomsRatings = new int[COUNT_OF_GROOM];
        return readRandomRating(groomsRatings);

    }

    public static int[] readRandomRating(int[] groomRatings) {
        Random random = new Random();
        for (int i = 0; i < groomRatings.length; i++) {
            groomRatings[i] = random.nextInt(100000) + 1;
        }
        return groomRatings;
    }

    public static int findBetterBeginRating(int[] groomsRatings, int index) {
        int better = groomsRatings[0];
        for (int i = 0; i < index; i++) {
            if (better < groomsRatings[i]) {
                better = groomsRatings[i];
            }
        }
        return better;
    }

    public static int findBetterEndRating(int[] groomsRatings, int better) {
        for (int i = 0; i < groomsRatings.length; i++) {
            if (better < groomsRatings[i]) {
                better = groomsRatings[i];
                return better;
            }
        }

        return groomsRatings[groomsRatings.length - 1];
    }

    public static int checkChoiceBride(int[] groomsRatings, int choiceOfBride) {
        for (int i = 0; i < groomsRatings.length; i++) {
            if (choiceOfBride < groomsRatings[i]) {
                return 0;
            }
        }
        return 1;
    }

    public static void printResult(int countGroom, double chance) {
        System.out.printf("Вероятность выбора лучшего жениха при переборе " + countGroom + " женихов до этого = " + "%.1f", +100 * (chance));
        System.out.println("%");
    }
}
