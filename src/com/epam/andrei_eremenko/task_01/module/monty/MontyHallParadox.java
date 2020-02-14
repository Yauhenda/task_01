package com.epam.andrei_eremenko.task_01.module.monty;

public class MontyHallParadox {

    static final byte QUANTITY_OF_DOORS = 3;
    static final byte VALUE_OF_CAR = 1;
    private static final int QUANTITY_OF_LAUNCHES = 10000000;
    private static int winsQuantityWithoutChanging = 0;
    private static int winsQuantityWithChanging = 0;
    private static byte[] doors = new byte[MontyHallParadox.QUANTITY_OF_DOORS];

    public MontyHallParadox(){
        playAlgorithm();
    }

    private static void playAlgorithm() {

        for (int i = 0; i < QUANTITY_OF_LAUNCHES; i++) {
            CarHider.hideCar(doors);

            if (DoorSelector.selectTheDoor() == 1) {
                winsQuantityWithoutChanging++;
            } else {
                winsQuantityWithChanging++;
            }
        }
    }

    @Override
    public String toString(){
        return "Количество запусков: " + QUANTITY_OF_LAUNCHES +
                "; Количество выйгрышей, если меняем дверь: " + winsQuantityWithChanging +
                ": Количество выйгрышей, если не меняем: " + winsQuantityWithoutChanging;
    }
}
