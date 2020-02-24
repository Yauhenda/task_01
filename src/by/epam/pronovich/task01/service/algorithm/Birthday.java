package by.epam.pronovich.task01.service.algorithm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.math.RoundingMode.DOWN;

public class Birthday {

    private static final int COUNT_OF_CHECKS = 1_000;
    private static final int DAYS_IN_YEAR = 365;
    public static final int PEOPLES = 23;
    private static final double PROCENT = 100;
    private static final Random RANDOM = new Random();


    public double calcProcOfCoincidence() {
        double coincidence=0;
        Set<Integer> group = new HashSet<>();
        for (int i = 0; i < COUNT_OF_CHECKS; i++) {
            for (int j = 0; j < PEOPLES; j++) {
                group.add(RANDOM.nextInt(DAYS_IN_YEAR) + 1);
            }
            if (group.size()<PEOPLES){
                coincidence++;
            }
            group.clear();
        }
        double proc=coincidence/COUNT_OF_CHECKS*PROCENT;
        return new BigDecimal(proc).setScale(1,DOWN).doubleValue();
    }
}
