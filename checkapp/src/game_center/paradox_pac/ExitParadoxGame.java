package game_center.paradox_pac;

public class ExitParadoxGame implements ParadoxChecker{

    private final String MESSAGE = "Exit";


    @Override
    public void run() {
        System.out.println(MESSAGE);
    }

    @Override
    public void printTitle() {
        System.out.println(MESSAGE);
    }
}
