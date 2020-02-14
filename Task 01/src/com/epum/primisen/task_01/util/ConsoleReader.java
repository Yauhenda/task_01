package com.epum.primisen.task_01.util;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader(){
        scanner = new Scanner(System.in);
    }

    public int readNumFromOneToDiapason(int maxValue){

        int number = 0;
        do{
            System.out.println("Enter your choose:");

            while (!scanner.hasNextInt()){
                System.out.println("Invalid value. Try again.");
                scanner.next();
            }

            number = scanner.nextInt();
        }while (number <= 0 || number > maxValue);

        return number;
    }
}
