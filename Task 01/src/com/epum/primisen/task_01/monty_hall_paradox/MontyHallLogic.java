package com.epum.primisen.task_01.monty_hall_paradox;

import java.util.Random;

public class MontyHallLogic {

    private MontyHall montyHall;

    public MontyHallLogic(MontyHall montyHall){
        this.montyHall = montyHall;
    }

    public void play(){
        determineWinningDoor();

    }

    private void determineWinningDoor(){

        Random random = new Random();
        int diapason = montyHall.getDoor().length;

        montyHall.setDoor(random.nextInt(diapason), true);
    }

    private int getIndexWinningDoor(){

        int i = 0;
        while (!montyHall.getDoor(i) && i < montyHall.getDoor().length){
            i++;
        }

        return i;
    }
}
