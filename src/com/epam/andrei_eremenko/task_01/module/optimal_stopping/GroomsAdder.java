package com.epam.andrei_eremenko.task_01.module.optimal_stopping;


class GroomsAdder {

    static void addNewGrooms(int[] grooms) {

        for (int i = 0; i < grooms.length; i++) {
            grooms[i] = (int) (Math.random()*100);
        }
    }
}
