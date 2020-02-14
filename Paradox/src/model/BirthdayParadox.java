package model;

import java.util.Arrays;
import java.util.Random;

public class BirthdayParadox extends Paradox {

    private static int day = 365;

    public void startParadox(int count, int length) {
        int counterDouble = 0;
        for (int i = 0; i <= count - 1; i++) {
            int[] datesBirthday = writeArray(length, BirthdayParadox.day);
            counterDouble = checkBirthdays(datesBirthday) + counterDouble;
        }

        System.out.println("Количество дублирующихся дней рождений: " + counterDouble);
        double probability = calculationProbability(counterDouble, count);
        System.out.println("Вероятность составляет " + probability + "%");
    }

    private int checkBirthdays(int[] datesBirthday) {
        Arrays.sort(datesBirthday);
        for (int i = 0; i < datesBirthday.length - 1; i++) {
            if (datesBirthday[i] == datesBirthday[i + 1]) {
                return 1;
            }
        }
        return 0;
    }

}
