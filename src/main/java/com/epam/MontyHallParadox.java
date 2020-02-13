package com.epam;

import java.util.Random;

import static com.epam.Main.keyboardInput;

public class MontyHallParadox {
    public static final int maxAttemp = 10;
    public static final int minAttemp = 1;
    public static boolean prize[] = new boolean[3];
    public static int winStatictics[];

    public static void montyHallAlgorithm() {
        int attempt;
        int doorNumber;
        int loseDoor;
        int answer;
        int finalAnswer = 1;
        do {
            System.out.println("введите количество попыток (от 1 до 10)");
            attempt = keyboardInput();
        } while (attempt < minAttemp || attempt > maxAttemp);
        winStatictics = new int[attempt];
        for (int i = 0; i < attempt; i++) {
            prize = generatePrize(prize);
            do {
                System.out.println("перед вами 3 двери: номер -'1', номер -'2', номер -'3', выберите любую дверь:");
                doorNumber = keyboardInput();
            } while (doorNumber < 1 || doorNumber > 3);
            loseDoor = checkDoors(prize, doorNumber);
            for (int j = 1; j < prize.length + 1; j++) {
                if (j != doorNumber && j != loseDoor) {
                    do {
                        System.out.println("Хотите ли вы поменять свой выбор в пользу двери номер -'" + j + "'");
                        System.out.println("1 -'Да'");
                        System.out.println("2-'Нет'");
                        answer = keyboardInput();
                    } while (answer < 1 || answer > 2);
                    if (checkAnswer(answer)) {
                        doorNumber = j;
                    }
                }
            }
            checkWin(prize,doorNumber);
        }
    }


    public static boolean[] generatePrize(boolean[] prize) {
        Random random = new Random();
        int number = random.nextInt(3) + 1;
        switch (number) {
            case 1:
                prize[0] = true;
                prize[1] = false;
                prize[2] = false;
                break;
            case 2:
                prize[0] = false;
                prize[1] = true;
                prize[2] = false;
                break;
            case 3:
                prize[0] = false;
                prize[1] = false;
                prize[2] = true;
                break;
        }
        return prize;
    }

    public static int checkDoors(boolean[] prize, int doorsNumber) {

        for (int i = 1; i < prize.length + 1; i++) {
            if (prize[i - 1] == false && i != doorsNumber) {
                System.out.println("За дверью номер -'" + i + "' приза нет!");
                return i;
            }
        }
        return 0;
    }

    public static boolean checkAnswer(int answer) {
        if (answer == 1) {
            return true;
        } else {
            return false;
        }

    }
    public static void checkWin(boolean[] prize, int doorNumber){
       if(prize[doorNumber-1]==true){
           System.out.println("вы победили");
        }
        else {
           System.out.println("Вы проиграли");
       }

    }

    public static void errorMessage() {
        System.out.println("Данные введены некорректно, пожалуйста, введите число от 1 до 10");
    }
}
