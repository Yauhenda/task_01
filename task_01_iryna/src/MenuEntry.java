public abstract class MenuEntry {

    private String option;
    private String menuLine;

    public MenuEntry(String option, String menuLine) {
        this.option = option;
        this.menuLine = menuLine;
    }

    @Override
    public String toString() {
        return this.option + " - " + this.menuLine;
    }

    public String getOption() {
        return option;
    }

    public abstract void doAction();

}

