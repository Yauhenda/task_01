package com.epam.andrei_eremenko.task_01.module.optimal_stopping;

public class OptimalStoppingAlgorithm {

    static final int QUANTITY_OF_GROOMS = 100;
    static final int STEEP = 10;
    static int quantityOfTries = 1000;
    private static int[] grooms = new int[OptimalStoppingAlgorithm.QUANTITY_OF_GROOMS];
    static int[] ratesAmount = new int[OptimalStoppingAlgorithm.STEEP];
    private static double[] averageRates = new double[ratesAmount.length];


    public OptimalStoppingAlgorithm(){
        playAlgorithm();
    }

    private static void playAlgorithm() {

        calculateRates();
        AverageValuesCalculator.calculateAverageRates(ratesAmount, averageRates);
    }


    private static void calculateRates() {
        for (int i = 0; i < OptimalStoppingAlgorithm.quantityOfTries; i++) {
            GroomsAdder.addNewGrooms(grooms);
            RatesCalculator.sumRates(grooms);
        }
    }

    @Override
    public String toString() {
        return
                "при шаге в " + STEEP + " женихов, среднией рейтинг: " + averageRates[0] +
                        "\nпри шаге в 20 женихов, среднией рейтинг: " + averageRates[1] +
                        "\nпри шаге в 30 женихов, среднией рейтинг: " + averageRates[2] +
                        "\nпри шаге в 40 женихов, среднией рейтинг: " + averageRates[3] +
                        "\nпри шаге в 50 женихов, среднией рейтинг: " + averageRates[4] +
                        "\nпри шаге в 60 женихов, среднией рейтинг: " + averageRates[5] +
                        "\nпри шаге в 70 женихов, среднией рейтинг: " + averageRates[6] +
                        "\nпри шаге в 80 женихов, среднией рейтинг: " + averageRates[7] +
                        "\nпри шаге в 90 женихов, среднией рейтинг: " + averageRates[8] +
                        "\nпри шаге в 100 женихов, среднией рейтинг: " + averageRates[9] +
                        "\nКоличество проверок по каждому шаге: " + quantityOfTries +
                        "\nКоличество женихов при каждой проверке: " + QUANTITY_OF_GROOMS;
    }
}


