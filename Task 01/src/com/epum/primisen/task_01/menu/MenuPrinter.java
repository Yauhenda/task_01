package com.epum.primisen.task_01.menu;

public class MenuPrinter {
    private Menu menu;

    public MenuPrinter(Menu menu){
        this.menu = menu;
    }

    public void print(){
        System.out.println(menu.getDescriptionOfMenu());
        System.out.println(menu.getGameList());
    }
}
