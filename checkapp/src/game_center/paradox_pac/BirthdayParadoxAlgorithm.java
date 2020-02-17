package game_center.paradox_pac;

import java.util.*;

public class BirthdayParadoxAlgorithm implements ParadoxChecker{

    private final String TITLE = "Birthday Paradox";
    private final int PEOPLE_COUNT = 23;
    private final int DAYS_IN_YEAR = 365;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private int numberOfIterations;
    private int duplicate;

    private int selectOfIterations() {
        while (numberOfIterations <= 1) {
            System.out.println("Choose the number of iterations");
            numberOfIterations = scanner.nextInt();
        }
        return numberOfIterations;
    }

    @Override
    public void run() {
        int countOfIterations = selectOfIterations();

        for (int k = 0; k < countOfIterations; k++) {
            boolean foundDuplicate = false;
            int[] birthdate = new int[PEOPLE_COUNT];

            for (int i = 0; i < PEOPLE_COUNT; i++) {
                birthdate[i] = random.nextInt(DAYS_IN_YEAR) + 1;
            }

            for (int i = 1; i <= DAYS_IN_YEAR; i++) {
                int num = 0;
                for (int j = 0; j < PEOPLE_COUNT; j++) {
                    if (birthdate[j] == i) {
                        num++;
                    }
                }
                if (num > 1) {
                    foundDuplicate = true;
                }
                num = 0;
            }

            if (foundDuplicate) {
                duplicate++;
            }
        }

        printResalt();
    }

    public void printResalt() {
        double result = (double) duplicate / numberOfIterations;
        System.out.println("Chance to meet a person in a group with" +
                " the same date of birth is " + result);
    }

    public void printTitle() {
        System.out.println(TITLE);
    }
}