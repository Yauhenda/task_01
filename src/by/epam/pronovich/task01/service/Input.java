package by.epam.pronovich.task01.service;

import by.epam.pronovich.task01.view.View;
import java.util.Scanner;

public class Input {

    public int readInput() {
        int result;
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println(View.welcomeMessage());
            scanner.next();
        }
        return result = scanner.nextInt();
    }
}
