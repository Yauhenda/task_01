package game_center;

import game_center.game_exception.IllegalNumberException;
import game_center.paradox_pac.MarriageProblemAlgorithm;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.run();
        } catch (IllegalNumberException ex) {
            System.out.println("Illegal number");
        }
    }
}
