package by.epam.pronovich.task01.service.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.math.RoundingMode.DOWN;

public class Lady {

    private static final int COUNT_OF_CHECKS = 1_000;
    public static final int COUNT_OF_FIANCE = 100;
    private static final double PROCENT = 100;

    public double calProcOfRightChoice() {
        double rightChoice = 0;
        int dropStep = (int) (COUNT_OF_FIANCE / Math.exp(1));
        int finalChoice = 0;
        int currentBestCandidate = 0;

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= COUNT_OF_FIANCE; i++) {
            candidates.add(i);
        }

        for (int j = 0; j < COUNT_OF_CHECKS; j++) {
            Collections.shuffle(candidates);
            for (int i = 0; i < candidates.size(); i++) {
                int currentFiance = candidates.get(i);
                if (currentBestCandidate < currentFiance && i < dropStep) {
                    currentBestCandidate = currentFiance;
                } else if (i >= dropStep && currentFiance > currentBestCandidate) {
                    finalChoice = currentFiance;
                    break;
                }
            }
            if (finalChoice == COUNT_OF_FIANCE) {
                rightChoice++;
            }
            currentBestCandidate = 0;
            finalChoice = 0;
        }
        double proc=rightChoice/COUNT_OF_CHECKS*PROCENT;
        return new BigDecimal(proc).setScale(1, DOWN).doubleValue();
    }
}
