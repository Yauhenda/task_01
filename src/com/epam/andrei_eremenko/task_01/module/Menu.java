package com.epam.andrei_eremenko.task_01.module;


import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Menu {
    private static int itemsCounter = 0;
    private Map<Integer, Paradox> menu = new HashMap<>();

    public Menu() {
    }

    private Supplier<String> supplier = () -> {
        Formatter formatter = new Formatter();
        formatter.format("%nChoose the item:");

        for (Map.Entry<Integer, Paradox> entry : menu.entrySet()) {
            formatter.format("%n%d = %s", entry.getKey(), entry.getValue());
        }
        formatter.format("%n%d = Finish program", ++itemsCounter);
        return formatter.toString();
    };

    public int getMenuSize() {
        return menu.size();
    }

    public Paradox getItem(int key) {
        return menu.get(key);
    }

    public void cleanMenu() {
        menu.clear();
    }

    public void fillMenu() {
        itemsCounter = Paradox.getIdCounter();
        menu.put(++itemsCounter, new MontyHallParadox());
        menu.put(++itemsCounter, new BirthdayParadox());
        menu.put(++itemsCounter, new OptimalStoppingParadox());
    }

    public String printMenu() {
        return supplier.get();
    }
}