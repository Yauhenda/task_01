package com.epam.andrei_eremenko.task_01.module;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;
import java.util.function.Supplier;

public class MontyHallParadox extends Paradox {

    private static final byte QUANTITY_OF_DOORS = 3;
    private static final byte VALUE_OF_CAR = 1;
    private static final int QUANTITY_OF_LAUNCHES = 10000000;
    private static int winsQuantityWithoutChanging = 0;
    private static int winsQuantityWithChanging = 0;
    private static byte[] doors = new byte[MontyHallParadox.QUANTITY_OF_DOORS];
    private static Random rand = new Random();

    public MontyHallParadox() {
        super("Monty hall paradox");
    }

    private Supplier<String> supplier = () -> {
        Formatter formatter = new Formatter();
        formatter.format("Wins quantity with changed door is %d;%n" +
                        "Wins quantity without changed doors is %d;%n" +
                        "Quantity of algorithm launches is %d",
                winsQuantityWithChanging, winsQuantityWithoutChanging, QUANTITY_OF_LAUNCHES);
        return formatter.toString();
    };

    private static void playAlgorithm(byte[] doors) {

        for (int i = 0; i < MontyHallParadox.QUANTITY_OF_LAUNCHES; i++) {
            hideCar(doors);

            if (selectTheDoor() == MontyHallParadox.VALUE_OF_CAR) {
                winsQuantityWithoutChanging++;
            } else {
                winsQuantityWithChanging++;
            }
        }
    }

    private static int selectTheDoor() {
        return rand.nextInt(MontyHallParadox.QUANTITY_OF_DOORS);
    }

    private static void hideCar(byte[] doors) {
        doors[rand.nextInt(MontyHallParadox.QUANTITY_OF_DOORS)] =
                MontyHallParadox.VALUE_OF_CAR;
    }

    @Override
    public String getResult() {
        playAlgorithm(doors);
        return supplier.get();
    }

    public static void resetVariables() {
        winsQuantityWithChanging = 0;
        winsQuantityWithoutChanging = 0;
        Arrays.fill(doors, (byte) 0);
    }

    @Override
    public String toString() {
        return getName();
    }
}
