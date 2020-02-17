package game_center;

import game_center.game_exception.IllegalNumberException;
import game_center.paradox_pac.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<ParadoxChecker> entries = new ArrayList<ParadoxChecker>();
    private Scanner scanner = new Scanner(System.in);
    private boolean isExit = false;
    private int gameNumber;

    public Menu() {
        entries.add(new BirthdayParadoxAlgorithm());
        entries.add(new MarriageProblemAlgorithm());
        entries.add(new MontyHallAlgorithm());
        entries.add(new ExitParadoxGame());

    }
    
    private void printMenu() {
        int currentGame = 0;
        for (ParadoxChecker paradoxChecker:entries) {
            System.out.print(currentGame++ + " ");
            paradoxChecker.printTitle();
        }
    }

    public void run() throws IllegalNumberException {
        System.out.println("Choose ur game for play or exit");
        
        while (!isExit) {
            printMenu();
            gameNumber = scanner.nextInt();
            if (gameNumber < 0 || gameNumber > 3) {
                IllegalNumberException ex = new IllegalNumberException("Illegal number",gameNumber);
                throw ex;
            }
            entries.get(gameNumber).run();
            if (gameNumber == 3) {
                isExit = true;
            }
        }
    }
}
