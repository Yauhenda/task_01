public abstract class MenuActions {
    private int action;
    private String menuLine;

    public MenuActions(int action, String menuLine) {
        this.action = action;
        this.menuLine = menuLine;
    }

    @Override
    public String toString() {
        return this.action + " - " + this.menuLine;
    }

    public int getAction() {
        return action;
    }

    public abstract void doAction();
}

