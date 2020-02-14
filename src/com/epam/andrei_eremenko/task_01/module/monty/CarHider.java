package com.epam.andrei_eremenko.task_01.module.monty;

import java.util.Random;

class CarHider {

    static void hideCar(byte[] doors) {
        Random rand = new Random();
        doors[rand.nextInt(MontyHallParadox.QUANTITY_OF_DOORS)] =
                MontyHallParadox.VALUE_OF_CAR;
    }
}
