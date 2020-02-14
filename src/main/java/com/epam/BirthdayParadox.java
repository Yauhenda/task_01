package com.epam;

import java.util.Random;

import static com.epam.Main.keyboardInput;

public class BirthdayParadox {
    public static final int MAX_COUNT_PEOPLE = 50;
    public static final int MIN_COUNT_PEOPLE = 2;

    public static void birthdayParadoxAlgorithm() {
        double chance = 0;
        int countPeople;
        do {
            System.out.println("Введите количество человек для расчёта вероятности того, что кто-то из них родился в один день (от 2 до 50)");
            countPeople = keyboardInput();
        } while (countPeople < MIN_COUNT_PEOPLE || countPeople > MAX_COUNT_PEOPLE);
        for (int i = 0; i < 1000000; i++) {
            chance += checkEqualBirthDay(createArrayBirthDay(countPeople));
        }
        printResult(countPeople, chance / 1000000.0);
    }

    public static int[] createArrayBirthDay(int countPeople) {
        int[] birthdays = new int[countPeople];
        return readRandomBirthDay(birthdays);
    }

    public static int[] readRandomBirthDay(int[] birthdays) {
        Random random = new Random();
        for (int i = 0; i < birthdays.length; i++) {
            birthdays[i] = random.nextInt(365) + 1;
        }
        return birthdays;
    }

    public static int checkEqualBirthDay(int[] birthdays) {
        for (int i = 0; i < birthdays.length; i++) {
            for (int j = i + 1; j < birthdays.length; j++) {
                if (birthdays[i] == birthdays[j]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void printResult(int countPeople, double chance) {
        System.out.printf("Вероятность того, что из " + countPeople + " человек, найдутся те, кто родился в один день = " + " %.2f", (chance * 100));
        System.out.println("%");
    }

}
