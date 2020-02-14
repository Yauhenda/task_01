package model;

import java.util.ArrayList;

class Choice {
    private int choice;
    private ArrayList<Boolean> arrayList;
    private boolean solution;


    Choice(int choice, ArrayList<Boolean> arrayList) {
        this.choice = choice;
        this.arrayList = arrayList;
    }

    int getChoice() {
        return choice;
    }

    void setChoice(int choice) {
        this.choice = choice;
    }

    ArrayList<Boolean> getArrayList() {
        return arrayList;
    }

    void setArrayList(ArrayList<Boolean> arrayList) {
        this.arrayList = arrayList;
    }
    boolean getSolution() {
        return solution;
    }
    void setSolution(boolean solution) {
        this.solution = solution;
    }

}
