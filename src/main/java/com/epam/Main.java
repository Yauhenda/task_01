package com.epam;

import java.util.Scanner;

import static com.epam.BirthdayParadox.birthdayParadoxAlgorithm;
import static com.epam.MontyHallParadox.montyHallAlgorithm;

public class Main {
    public static void main(String[] args) {

        int actionNumber;

        while (true) {
            do {
                outputChoice();
                actionNumber = keyboardInput();
            } while (actionNumber < 1 || actionNumber > 4);
            chooseAlgorithm(actionNumber);
        }
    }

    public static void outputChoice() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Парадокс Монти Холла");
        System.out.println("2 - Парадокс Дней Рождения ");
        System.out.println("3 - задачи о разборчивой невесте");
        System.out.println("4 - завершить работу");
    }

    public static int keyboardInput() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        int inputNumber = checkIsInteger(inputString);

        return inputNumber;
    }

    public static int checkIsInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Не верный тип данных, введите число");
            return keyboardInput();
        }
        return Integer.parseInt(inputString);
    }

//    public static int inputCheck(int actionNumber) {
//        if (actionNumber > 0 && actionNumber < 5) {
//            return actionNumber;
//        }
//        System.out.println("Данные введены некорректно, пожалуйста, введите число от 1 до 4");
//        return keyboardInput();
//    }

    public static void chooseAlgorithm(int actionNumber) {
        switch (actionNumber) {
            case 1:montyHallAlgorithm();
                break;
            case 2:
                birthdayParadoxAlgorithm();
                break;
            case 3:
                break;
            case 4:
                System.exit(0);
        }
    }

//    public static void errorMessage() {
//        System.out.println("Данные введены некорректно, пожалуйста, введите число от 1 до 4");
//    }
}

