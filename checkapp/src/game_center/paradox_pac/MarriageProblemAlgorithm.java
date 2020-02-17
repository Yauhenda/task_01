package game_center.paradox_pac;

import java.util.Random;
import java.util.Scanner;

public class MarriageProblemAlgorithm implements ParadoxChecker {

    private final String TITLE = "Marriage Problem";
    private final double NUMBER_E = 0.36;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 100;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private static double averageArithmetic = 0;
    private int countOfCandidate;
    private long numberOfIterations;

    private long selectIterations() {
        while (numberOfIterations <= 0) {
            System.out.println("Choose the number of iterations");
            numberOfIterations = scanner.nextLong();
        }
        return numberOfIterations;
    }

    private int selectCandidate() {
        while (countOfCandidate <= 0) {
            System.out.println("Choose the count of candidates");
            countOfCandidate = scanner.nextInt();
        }
        return countOfCandidate;
    }

    private int[] initArray() {
        int[] candidates = new int[countOfCandidate];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = random.nextInt(MAX_VALUE) + MIN_VALUE;
        }
        return candidates;
    }

    @Override
    public void run() {
        long countOfIterations = selectIterations();
        int numberOfCandidates = selectCandidate();

        for (int i = 0; i < countOfIterations; i++) {
            int bestResult = 0;
            int bestCandidate = 0;
            int[] candidates = initArray();

            int firstRejected = (int) (numberOfCandidates - (numberOfCandidates * NUMBER_E));

            for (int j = 0; j < candidates.length - firstRejected; j++) {
                if (bestCandidate <= candidates[j]) {
                    bestCandidate = candidates[j];
                }
            }

            for (int j = firstRejected; j < candidates.length; j++) {
                if (bestCandidate > candidates[j]) {
                    bestResult = 0;
                } else if(bestCandidate < candidates[j]) {
                    bestResult = candidates[j];
                    break;
                }
            }
            averageArithmetic += bestResult;
        }
        printResalt();
    }

    public void printResalt() {
        double result = averageArithmetic / numberOfIterations;
        System.out.println("Average arithmetic is " + result);
    }

    public void printTitle() {
        System.out.println(TITLE);
    }
}
