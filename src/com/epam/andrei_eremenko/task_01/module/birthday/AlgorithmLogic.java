package com.epam.andrei_eremenko.task_01.module.birthday;

class AlgorithmLogic {
    static void calculateProbability(short[][] array) {

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
}
