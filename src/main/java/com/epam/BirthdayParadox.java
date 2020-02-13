package com.epam;
import static com.epam.Main.keyboardInput;

public class BirthdayParadox {
    public static final int days = 365;
    public static final int maxCountPeople = 365;
    public static final int minCountPeople = 2;
    public static float chance = 1;

    public static void birthdayParadoxAlgorithm() {
        int countPeople;
        do {
            System.out.println("Введите количество человек для расчёта вероятности того, что они родились в разные дни (от 2 до 365)");
            countPeople = keyboardInput();
        } while (countPeople <= minCountPeople || countPeople >= maxCountPeople);
        chance = countChance(countPeople);
        printResult(countPeople);
    }

//    public static int readCountPeople() {
//        Scanner scanner = new Scanner(System.in);
//        String inputString = scanner.nextLine();
//        int numberOfPeople = checkIsInteger(inputString);
//        checkCountPeople(numberOfPeople);
//        return numberOfPeople;
//    }


    public static float countChance(int countPeople) {
        for (int i = (days + 1) - countPeople; i <= days; i++) {
            chance = chance * i;
            chance = chance / days;
        }
        return chance;
    }

//    public static int checkIsInteger(String inputString) {
//        try {
//            Integer.parseInt(inputString);
//        } catch (NumberFormatException e) {
//            errorMessage();
//            return readCountPeople();
//        }
//        return Integer.parseInt(inputString);
//    }

//    public static int checkCountPeople(int numberOfPeople) {
//        if (numberOfPeople >= minCountPeople && numberOfPeople <= maxCountPeople) {
//            return numberOfPeople;
//        } else {
//            errorMessage();
//            return readCountPeople();
//        }
//    }

    public static void printResult(int countPeople) {
        System.out.printf("Вероятность того, что из " + countPeople + " человек, найдутся те, кто родился в один день = " + " %.58f", 100 * (1.0 - chance));
        System.out.println("%");
        chance = 1;
    }

    public static void errorMessage() {
        System.out.println("Данные введены некорректно, введите число от 2 до 365");
    }
}
