package com.epum.primisen.task_01.monty_hall_paradox;

public class MontyHall {

    public static final int NUMBER_OF_DOOR = 3;

    private boolean[] door;

    public MontyHall(){
        door = new boolean[NUMBER_OF_DOOR];
    }

    public boolean[] getDoor() {
        return door;
    }

    public void setDoor(boolean[] door) {
        this.door = door;
    }

    public boolean getDoor(int index){//обработать исключение, если значение индекса недопустимо
        return door[index];
    }

    public void setDoor(int index, boolean value){//обработать исключение, если значение индекса недопустимо
        door[index] = value;
    }

    //переопределить
//    @Override
//    public int hashCode(){
//        int result = 107;
//        for (int i = 0; i < door.length; i++) {
//            door[i] == true
//        }
//
//        return
//    }
}
