package com.epam.andrei_eremenko.task_01.controller.srg;

import com.epam.andrei_eremenko.task_01.module.*;
import com.epam.andrei_eremenko.task_01.view.Printer;

import java.io.File;
import java.util.Scanner;


public class Controller {
    private static Scanner sc = new Scanner(System.in);
    private File file = new File("OUTPUT.TXT");

    public void execute() {
        Menu menu = new Menu();
        resetVariables();
        menu.cleanMenu();
        Paradox.resetIdCounter();
        menu.fillMenu();
        new Printer<String>().print(menu.printMenu());
        String select = sc.next();

        try {
            int temp = selectItemViaMap1(select);

            if (temp < 1 || temp > menu.getMenuSize() + 1) {
                System.err.println("Inputted data does not match the menu");
                execute();
            } else if (temp == menu.getMenuSize() + 1) {
                new Printer<String>().print("Program finished");
            } else {
                new Printer<String>().print(menu.getItem(temp).getResult());
                new Printer<Paradox>().print(menu.getItem(temp), file);
                execute();
            }
        } catch (NumberFormatException ex) {
            System.err.println("Incorrect data input. Please try again:");
            execute();
        } finally {
            sc.close();
        }
    }

    private int selectItemViaMap1(String select) throws NumberFormatException {
        return Integer.parseInt(select);
    }

    private void resetVariables() {
        MontyHallParadox.resetVariables();
        BirthdayParadox.resetVariables();
        OptimalStoppingParadox.resetVariables();
    }

    @Deprecated
    @SuppressWarnings("unused")
    /* The method replaced by the selectItemViaMap method **/
    private void selectItemViaSwitch(String select) {

        switch (select) {
            case ("1"):
                new Printer<String>().print(new MontyHallParadox().getResult());
                MontyHallParadox.resetVariables();
                break;
            case ("2"):
                new Printer<String>().print(new BirthdayParadox().getResult());
                BirthdayParadox.resetVariables();
                break;
            case ("3"):
                new Printer<String>().print(new OptimalStoppingParadox().getResult());
                OptimalStoppingParadox.resetVariables();
                break;
            case ("4"):
                new Printer<String>().print("Program finished");
                break;
            default:
                new Printer<String>().print("The inputted data dose not match the menu");
                break;
        }
    }
}

