package service;

import model.BirthdayParadox;
import model.IncorrectException;
import model.MontyHoll;
import model.PickyBride;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Initializer {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Validator validator = new Validator();
    //  private Validator validator = new Validator();


    static {
        System.out.println("Добрый день! Вас приветствует программа \"Решала парадоксов 3000\"!");
    }


    public void starter() throws IOException {

        System.out.println("Введите номер прорверки алгоритма который Вам необходим:" + "\n" +
                "1. Проверка парадокса Монти-Холла." + "\n" +
                "2. Проверка парадокса дней рождения." + "\n" +
                "3. Проверка решения Задачи о разборчивой невесте." + "\n" +
                "0. Выход");

        String function = reader.readLine();
        switch (function) {
            case "1":
                getMontyHollParadox();
                break;
            case "2":
                getBirthdayParadox();
                break;
            case "3":
                getPickyBride();
                break;
            case "0":
                reader.close();
                System.out.println("Спасибо, что пользуетесь нашим программным продуктом!");
                System.exit(0);
            default:
                System.out.println("Ошибка. Данного значения не существует. Проверьте номер функции " +
                        "и попробуйте еще раз.");
        }

        starter();
    }

    private void getPickyBride() throws IOException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + "\n" +
                "Проверка задачи о разборчивой невесте" + "\n"
                + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        try {
            System.out.println("Введите количество попыток проверки:");
            int count = validator.validateInt(reader.readLine());
            System.out.println("Введите процент до которого необходимо смотреть женихов:");
            int percent = validator.validateInt(reader.readLine());
            if(percent>=100){throw new IncorrectException("Количество процентов должно быть меньше 100.");}
            System.out.println("Также введите количество женихов:");
            int length = Integer.parseInt(reader.readLine());

            PickyBride pickyBride = new PickyBride();
            pickyBride.startParadox(count, length, percent);
        } catch (IncorrectException e) {
            e.printStackTrace();
        }

    }

    private void getMontyHollParadox() throws IOException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + "\n" +
                "Проверка парадокса Монти-Холла" + "\n" +
                "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Введите количество проверок:");

        try {
            int count = validator.validateInt(reader.readLine());
            MontyHoll montyHoll = new MontyHoll();
            montyHoll.startParadox(count);
        } catch (IncorrectException e) {
            e.printStackTrace();
        }
    }

    private void getBirthdayParadox() throws IOException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + "\n" +
                "Проверка парадокса дней рождения" + "\n"
                + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Для проведения проверки нам необходимо количество учеников в классе." + "\n"
                + "Введите количество учащихся:");

        try {
            int length = validator.validateInt(reader.readLine());
            System.out.println("Также введите количество проверок:");
            int count = validator.validateInt(reader.readLine());

            BirthdayParadox birthdayParadox = new BirthdayParadox();
            birthdayParadox.startParadox(count, length);
        } catch (IncorrectException e) {
            e.printStackTrace();
        }
    }


}
