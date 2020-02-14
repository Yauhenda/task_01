package service;

import model.IncorrectException;

class Validator {

    int validateInt(String number) throws IncorrectException {
        int numeric;
        try {
            numeric = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw  new IncorrectException("Данные символы" + number + " не поддерживаются программой."+
                    " Число должно быть целым и не содержать лишних символов");
        }
        if (numeric <= 0) {
            throw new IncorrectException("Ошибка в числе " + numeric + "Число должно быть больше нуля");
        }
        return numeric;
    }
}
