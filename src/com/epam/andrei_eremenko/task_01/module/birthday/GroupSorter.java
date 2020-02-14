package com.epam.andrei_eremenko.task_01.module.birthday;

import java.util.Arrays;

class GroupSorter {

    static void sortHumansByBirthday(short[][] array) {

        for (short[] shorts : array) {
            Arrays.sort(shorts);
        }
    }
}
