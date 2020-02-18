package model;

import java.util.Random;

abstract class Paradox {

    int[] writeArray(int length, int maxValue) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }

    int[] writeArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }
        return array;
    }

    double calculationProbability(int result, int count) {
       return (double) result / count * 100;

    }

}
