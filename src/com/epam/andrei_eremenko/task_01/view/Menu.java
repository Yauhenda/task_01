package com.epam.andrei_eremenko.task_01.view;

public class Menu {

    public Menu(){
        System.out.println(toString());
    }

    @Override
    public String toString (){
        return
                "Выберите пункт: " +
                        "\n1 - проверка парадокса Монти Холла" +
                        "\n2 - проверка парадокса дней рождения" +
                        "\n3 - проверка алгоритма оптимальной остановки выбора" +
                        "\n4 - завершить программу";
    }



}
