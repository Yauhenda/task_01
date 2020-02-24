package by.epam.pronovich.task01.service.algorithm;

import java.math.BigDecimal;
import java.util.*;

import static java.math.RoundingMode.DOWN;

public class MontyHall {

    private static final int COUNT_OF_TRIES = 1_000;
    private List<String> doors = new ArrayList<>(Arrays.asList("goat", "goat", "auto"));
    private static final double PROCENT=100;
    private static final Random RANDOM= new Random();

    public double calcProcChanceToWinWithoutChange() {
        double win = 0;
        String prize = "auto";
        for (int i = 0; i < COUNT_OF_TRIES; i++) {
            Collections.shuffle(doors);
            if (prize.equals(doors.get(RANDOM.nextInt(doors.size())))) {
                win++;
            }
        }
        double proc = win / COUNT_OF_TRIES * PROCENT;
        return new BigDecimal(proc).setScale(1, DOWN).doubleValue();
    }

    public double calcProcChanceTowinWithChange(){
       return PROCENT-calcProcChanceToWinWithoutChange();
    }
}
