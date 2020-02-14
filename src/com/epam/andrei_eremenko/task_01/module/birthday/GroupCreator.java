package com.epam.andrei_eremenko.task_01.module.birthday;

import java.util.Random;

class GroupCreator {

    static void createGroups(short[][] array) {
        Random rand = new Random();

        for (short i = 0; i < array.length; i++) {

            for (short j = 0; j < array[i].length; j++) {
                array[i][j] = (short) (rand.nextInt(BirthdayParadox.DAYS) + 1);
            }
        }
    }
}
