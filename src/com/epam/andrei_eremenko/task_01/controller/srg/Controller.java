package com.epam.andrei_eremenko.task_01.controller.srg;

import com.epam.andrei_eremenko.task_01.module.birthday.BirthdayParadox;
import com.epam.andrei_eremenko.task_01.module.monty.MontyHallParadox;
import com.epam.andrei_eremenko.task_01.module.optimal_stopping.OptimalStoppingAlgorithm;
import com.epam.andrei_eremenko.task_01.view.Menu;

import java.util.Scanner;

public class Controller {
    public void execute() {

        int select = 0;
        do {
            new Menu();
            Scanner sc = new Scanner(System.in);
            select = sc.nextInt();
            try {

                if (select != 1 && select != 2 && select != 3 && select != 4){
                    throw new IncorrectDataInputException("ввод не соответствует пунктам меню");
                }
            } catch (IncorrectDataInputException ex){
                System.err.println(ex.getMessage());
                execute();
            }

            switch (select) {
                case (1):
                    System.out.println(new MontyHallParadox().toString());
                    break;
                case (2):
                    System.out.println(new BirthdayParadox().toString());
                    break;
                case (3):
                    System.out.println(new OptimalStoppingAlgorithm().toString());
                    break;
            }

        } while (select != 4);


    }
}
