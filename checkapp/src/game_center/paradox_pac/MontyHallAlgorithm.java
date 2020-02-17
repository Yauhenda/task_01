package game_center.paradox_pac;

import java.util.Random;
import java.util.Scanner;

public class MontyHallAlgorithm implements ParadoxChecker{

    private final String TITLE = "Monty Hall game";
    private final int NUMBER_OF_CAR = 1;
    private final int NUMBER_OF_GOAT = 0;
    private final Random random = new Random();
    private int numberOfIterations;

    private int switchWins = 0;
    private int stayWins = 0;

    private int selectOfIterations() {
        while (numberOfIterations <= 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose the number of iterations");
            numberOfIterations = scanner.nextInt();
        }
        return numberOfIterations;
    }

    @Override
    public void run() {
        int countOfIterations = selectOfIterations();

        for (int games = 0; games < countOfIterations; games++) {
            int[] doors = {NUMBER_OF_GOAT,NUMBER_OF_GOAT,NUMBER_OF_GOAT};
            doors[random.nextInt(3)] = NUMBER_OF_CAR;
            int choice = random.nextInt(3);
            int shown;

            do {
                shown = random.nextInt(3);
            }while(doors[shown] == NUMBER_OF_CAR || shown == choice);

            stayWins += doors[choice];
            switchWins += doors[3 - choice - shown];
        }

        printResalt();
    }

    public void printResalt() {
        System.out.println("Switching wins " + switchWins + " times.\n" +
                "Staying wins " + stayWins + " times.\n");
    }

    public void printTitle() {
        System.out.println(TITLE);
    }
}
