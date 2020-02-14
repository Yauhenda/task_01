import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final String OPTION_EXIT = "0";
    private List<MenuEntry> menuOptions = new ArrayList<>();

    public void add(MenuEntry menuEntry){
        this.menuOptions.add(menuEntry);
    }

    public void loopUntilExit(){
        String input;
        Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println(this);
                input = sc.nextLine();
                if (input.equals(OPTION_EXIT)) {
                    return;
                }
                boolean foundOption = false;
                for (MenuEntry menuEntry : menuOptions) {
                    if (menuEntry.getOption().equals(input)) {
                        menuEntry.doAction();
                        foundOption = true;
                    }
                }
                if (!foundOption) {
                    //System.out.println("YOU SHALL NOT PASS!");
                    throw new IllegalArgumentException();
                }
            }

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Choose your fighter, push 0 to exit.\n");
        for(MenuEntry menuEntry : menuOptions){
            sb.append(menuEntry).append("\n");
        }
        return sb.toString();
    }
}