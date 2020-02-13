package by.epam.nickgrudnitsky.util;

import by.epam.nickgrudnitsky.data.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataInput {
    public static int readMenuNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Choose from the given numbers.");
            return readMenuNumber();
        }
        if (number < 0 || number >= Menu.values().length) {
            System.out.println("Choose from the given numbers.");
            return readMenuNumber();
        }
        return number;
    }

}
