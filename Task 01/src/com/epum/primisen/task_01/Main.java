package com.epum.primisen.task_01;

import com.epum.primisen.task_01.menu.Menu;
import com.epum.primisen.task_01.menu.MenuPrinter;
import com.epum.primisen.task_01.util.ConsoleReader;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.setDescriptionOfMenu("Choose a number of a game that is located below for start a game.");
        menu.setGameList("Monty Hall paradox");
        menu.setGameList("Birth paradox");
        menu.setGameList("Task of picky bride");

        MenuPrinter menuPrinter = new MenuPrinter(menu);
        menuPrinter.print();

        ConsoleReader consoleReader = new ConsoleReader();
        consoleReader.readNumFromOneToDiapason(menu.getNumberOfGame());


    }
}
