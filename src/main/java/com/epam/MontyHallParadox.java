package com.epam;

import java.util.Random;

import static com.epam.Main.keyboardInput;

public class MontyHallParadox {
    public static final int MAX_ATTEMP = 1_000_000;
    public static final int MIN_ATTEMP = 1;
    public static final int CHOICE = 1;

    public static void montyHallAlgorithm() {
        int attempt;
        double winStatictics = 0;
        do {
            System.out.println("введите количество попыток (от 1 до 1_000_000)");
            attempt = keyboardInput();
        } while (attempt < MIN_ATTEMP || attempt > MAX_ATTEMP);
        for (int i = 0; i < attempt; i++) {
            winStatictics += winCheck(generatePrize(), CHOICE);
        }
        printResult(winStatictics / attempt, attempt);
    }

    public static boolean[] generatePrize() {
        boolean[] prize = new boolean[3];
        Random random = new Random();
        int number = random.nextInt(3) + 1;
        switch (number) {
            case 1:
                prize[0] = true;
                prize[1] = false;
                prize[2] = false;
                break;
            case 2:
                prize[0] = false;
                prize[1] = true;
                prize[2] = false;
                break;
            case 3:
                prize[0] = false;
                prize[1] = false;
                prize[2] = true;
                break;
        }
        return prize;
    }

    public static int winCheck(boolean[] prize, int doorsNumber) {

        for (int i = 1; i < prize.length + 1; i++) {
            if (prize[i - 1] == true && i == doorsNumber) {
                return 1;
            }
        }
        return 0;
    }

    public static void printResult(double winStatistics, int attempt) {
        System.out.printf("При " + attempt + " количестве попыток, вероятность победить при смене выбора двери = " + "%.2f", +100 * (1 - winStatistics));
        System.out.println("%");
        System.out.printf("При " + attempt + " количестве попыток, вероятность победить без смены выбора двери = " + "%.2f", +100 * ( winStatistics));
        System.out.println("%");
    }
}
