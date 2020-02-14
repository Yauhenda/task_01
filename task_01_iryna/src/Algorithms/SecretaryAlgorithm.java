package Algorithms;

import java.util.ArrayList;
import java.util.Collections;


public class SecretaryAlgorithm implements Algorithm {

    private static final int NUMBER_OF_TRIES = 100_000;
    private static final int NUMBER_OF_CANDIDATES = 100;
    private static final double e = 2.71828;
    ArrayList<Integer> candidate = new ArrayList<>();

    public int countCandidates() {
        int result = 0;
        for (int i = 0; i < NUMBER_OF_CANDIDATES; i++) {
            candidate.add(i);
        }
        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            Collections.shuffle(candidate);
            if (findBestCandidate(candidate, NUMBER_OF_CANDIDATES) != 0) {
                result++;
            }
        }
        return result;
    }

    public void printResult() {
        double result = 1 - (1.0 * countCandidates() / NUMBER_OF_TRIES);
        System.out.println(result);
    }

    public int findBestCandidate(ArrayList<Integer> list, int n) {
        int result = 0;

        int sample_size = roundNo((float) (n / e));

        int best = 0;
        for (int i = 1; i < sample_size; i++)
            if (list.get(i) > list.get(best))
                best = i;

        for (int i = sample_size; i < n; i++)
            if (list.get(i) >= list.get(best)) {
                best = i;
                break;
            }

        if (best >= sample_size) {
            result++;
        }

        return result;
    }

    public int roundNo(float num) {
        return (int) (num < 0 ?
                num - 0.5 : num + 0.5);
    }
}
