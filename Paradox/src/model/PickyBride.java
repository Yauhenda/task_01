package model;

public class PickyBride extends Paradox {

    public void startParadox(int count, int length, int percent) {
        int sumTheBestBoys = 0;
        int checkBoys = (int) calculatePercent(length, percent);
        for (int i = 0; i < count; i++) {
            int[] array = writeArray(length);
            int maxValue = findMaxValueBeforePercent(array, checkBoys);
            int theBestBoy = findBoy(array, maxValue, checkBoys);
            sumTheBestBoys = sumTheBestBoys + theBestBoy;
        }
        System.out.println("При выполнении " + count + " попыток решения задачи с процентом " + percent +
                " и количеством женихов равным " + length +
                ". Средний рейтинг жениха составляет: " + sumTheBestBoys / count);

    }

    private double calculatePercent(int length, int percent) {
        return Math.ceil((double) length / 100 * percent);
    }

    private int findMaxValueBeforePercent(int[] array, int checkBoys) {
        int value = 0;
        for (int i = 0; i < checkBoys; i++) {
            if (array[i] > value) {
                value = array[i];
            }
        }
        return value;
    }

    private int findBoy(int[] array, int maxValue, int checkBoys) {
        for (int i = checkBoys; i < array.length; i++) {
            if (array[i] > maxValue) {
                return array[i];
            }
        }
        return 0;
    }

}
