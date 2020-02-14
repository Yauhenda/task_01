package com.epam.andrei_eremenko.task_01.module.optimal_stopping;

class AverageValuesCalculator {
    static void calculateAverageRates(int[] ratesAmount, double[] averageRates) {

        for (int i = 0; i < ratesAmount.length; i++) {
            averageRates[i] = (double) ratesAmount[i] /
                    (double) OptimalStoppingAlgorithm.quantityOfTries;
        }
    }
}
