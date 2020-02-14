package com.epam.andrei_eremenko.task_01.module.optimal_stopping;


class RatesCalculator {

    static void sumRates(int[] grooms) {
        int flag = 0;
        int nextStep = OptimalStoppingAlgorithm.STEEP;

        while (nextStep <= OptimalStoppingAlgorithm.QUANTITY_OF_GROOMS) {

            for (int i = nextStep - 1; i < grooms.length; i++) {
                int temp = grooms[nextStep - 1];

                if (grooms[i] > temp) {
                    OptimalStoppingAlgorithm.ratesAmount[flag] += grooms[i];
                    flag++;
                    break;
                } else if (i == grooms.length - 1) {
                    OptimalStoppingAlgorithm.ratesAmount[flag] += grooms[i];
                    flag++;
                    break;
                }
            }
            nextStep += OptimalStoppingAlgorithm.STEEP;
        }
    }
}