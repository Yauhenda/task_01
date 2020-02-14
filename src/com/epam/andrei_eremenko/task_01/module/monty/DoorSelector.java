package com.epam.andrei_eremenko.task_01.module.monty;

import java.util.Random;

class DoorSelector {

    static int selectTheDoor() {
        Random rand = new Random();
        return rand.nextInt(MontyHallParadox.QUANTITY_OF_DOORS);
    }
}
