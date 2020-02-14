package com.epam.andrei_eremenko.task_01.module.birthday;

public class BirthdayParadox {
    private static final short QUANTITY_OF_TRIES = 1000;
    private static final short QUANTITY_OF_HUMANS = 23;
    static final short DAYS = 365;
    private static short[][] array = new short[BirthdayParadox.QUANTITY_OF_TRIES][BirthdayParadox.QUANTITY_OF_HUMANS];
    static short frequencies = 0;

    public BirthdayParadox(){
        playAlgorithm();
    }

    private static void playAlgorithm() {
        GroupCreator.createGroups(array);
        GroupSorter.sortHumansByBirthday(array);
        AlgorithmLogic.calculateProbability(array);
    }

    @Override
    public String toString(){
        return "В группах количеством: " + QUANTITY_OF_HUMANS +
                " количество совпадений дней рождений у 2 и более людей составило " +
                frequencies +
                " случаев. Количество проверенных групп: " + QUANTITY_OF_TRIES;
    }


}
