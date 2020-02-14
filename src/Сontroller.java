import java.util.Scanner;

public class Сontroller {
    public static void start() {
        addAlgoInMenu();
        View.startMenu();
    }
    private static void addAlgoInMenu(){
        View.addAlgo(new MenuActions(1, "Monty Hall") {
            @Override
            public void doAction() {
                MontyHallAlgo.startAlgo();
            }
        });
        View.addAlgo(new MenuActions(2, "Birthday Paradox") {
            @Override
            public void doAction() {
                BirthdayParadoxAlgo.startAlgo();
            }
        });
        View.addAlgo(new MenuActions(3, "Secretary Problem") {
            @Override
            public void doAction() {
                SecretaryProblemAlgo.startAlgo();
            }
        });
    }
}
