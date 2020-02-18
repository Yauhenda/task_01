package model;

import java.util.*;

public class MontyHoll extends Paradox {

    private Random random = new Random();
    private static int firstPart = 3;


    public void startParadox(int count) {
        int[] answers = new int[4];
        for (int i = 0; i < count; i++) {
            ArrayList<Boolean> arrayList = writeArray();
            int index = choiceRandom(MontyHoll.firstPart);
            Choice choice = makeChoice(index, arrayList);
            choice = openVariable(choice);
            choice = changChoice(choice, makeSolution());
            int check = checkWin(choice);
            writeAnswer(answers, check);
        }
        System.out.println("Вероятность выйгрыша при смене составляет" + calculationProbability(answers[0], count));
        System.out.println("Вероятность выйгрыша без смены составляет" + calculationProbability(answers[1], count));
        System.out.println("Вероятность пройгрыша при смене составляет" + calculationProbability(answers[2], count));
        System.out.println("Вероятность пройгрыша без смены составляет" + calculationProbability(answers[3], count));

    }


    private int choiceRandom(int value) {
        return random.nextInt(value);
    }

    private ArrayList writeArray() {
        ArrayList<Boolean> array = new ArrayList<>(Arrays.asList(true, false, false));
        Collections.shuffle(array);
        return array;
    }

    private Choice makeChoice(int choice, ArrayList<Boolean> array) {
        return new Choice(choice, array);
    }

    private Choice openVariable(Choice choice) {
        ArrayList<Boolean> array = choice.getArrayList();
        int index = choice.getChoice();

        if (array.get(index)) {
            if (index == 0) {
                array.remove(1 + random.nextInt(2));
            } else if (index == 1) {
                int del = random.nextInt(2);
                if (del == 0) {
                    array.remove(0);
                    index--;
                } else {
                    array.remove(2);
                }
            } else if (index == 2) {
                array.remove(random.nextInt(2));
                index = 1;
            }

        } else if (!array.get(index)) {
            if (index == 0) {
                if (array.get(1)) {
                    array.remove(2);
                } else {
                    array.remove(1);
                }
            } else if (index == 1) {
                if (array.get(0)) {
                    array.remove(2);
                } else {
                    array.remove(0);
                    index--;
                }
            } else if (index == 2) {
                if (array.get(0)) {
                    array.remove(1);
                    index--;
                } else {
                    array.remove(0);
                    index--;
                }
            }
        }
        choice.setArrayList(array);
        choice.setChoice(index);
        return choice;
    }

    private boolean makeSolution() {
        return random.nextBoolean();
    }

    private Choice changChoice(Choice choice, boolean solution) {
        choice.setSolution(solution);
        if (solution) {
            if (choice.getChoice() == 0) {
                choice.setChoice(1);
            } else {
                choice.setChoice(0);
            }
        }
        return choice;
    }

    private int checkWin(Choice choice) {
        ArrayList<Boolean> arrayList = choice.getArrayList();
        int index = choice.getChoice();
        boolean solution = choice.getSolution();
        if (arrayList.get(index) && solution) {
            return 1;
        } else if (arrayList.get(index) && !solution) {
            return 2;
        } else if (!arrayList.get(index) && solution) {
            return 3;
        } else
            return 4;
    }

    private void writeAnswer(int[] array, int value) {
        switch (value) {
            case 1:
                array[0]++;
                break;
            case 2:
                array[1]++;
                break;
            case 3:
                array[2]++;
                break;
            case 4:
                array[3]++;
                break;
        }

    }

}

