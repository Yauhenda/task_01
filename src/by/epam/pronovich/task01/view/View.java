package by.epam.pronovich.task01.view;

import by.epam.pronovich.task01.service.algorithm.Birthday;
import by.epam.pronovich.task01.service.algorithm.Lady;
import by.epam.pronovich.task01.service.algorithm.MontyHall;
import by.epam.pronovich.task01.service.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class View {

    private View() {
    }

    public static void launch() {
        int value = -1;
        Input input = new Input();
        while (value != 0) {
            showMenu();
            value = input.readInput();
            doAction(value);
        }
    }

    private static void showMenu() {
        System.out.println(welcomeMessage());
        HashMap<Integer, String> menu = new HashMap<>();
        menu.put(1, "Monty Hall paradox");
        menu.put(2, "Birhday paradox");
        menu.put(3, "Lady paradox");
        Set<Map.Entry<Integer, String>> entries = menu.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }
    }

    private static void doAction(int value) {
        switch (value) {
            case (1): {
                printMontyHall();
                break;
            }
            case (2): {
                printBirhday();
                break;
            }
            case (3): {
                printLady();
            }
        }
    }

    private static void printMontyHall() {
        MontyHall montyHall = new MontyHall();
        System.out.println("Процент выигрыша без изменения решения " +
                montyHall.calcProcChanceToWinWithoutChange() + "%");
        System.out.println("Процент выигрыша если измененить решение " +
                montyHall.calcProcChanceTowinWithChange() + "%");
    }

    private static void printBirhday() {
        Birthday birthday = new Birthday();
        System.out.println("Процент совпадения Дня рождения в группе из " + Birthday.PEOPLES + " человек " +
                birthday.calcProcOfCoincidence() + "%");
    }

    private static void printLady() {
        Lady lady = new Lady();
        System.out.println("Вероятность выбора лучшего жениха из " + Lady.COUNT_OF_FIANCE + " человек " +
                lady.calProcOfRightChoice() + "%");
    }

    public static String welcomeMessage() {
        return "Please input value from 1 to 3 for you choice, or 0 to EXIT!";
    }

}
