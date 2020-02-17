package game_center.game_exception;

public class IllegalNumberException extends Exception {
    int number;

    public IllegalNumberException(String message, int number) {
        super(message);
        this.number = number;
    }

    @Override
    public String toString() {
        return "IllegalNumber" + number;
    }
}
