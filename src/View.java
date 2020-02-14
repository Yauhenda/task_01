import java.util.ArrayList;
import java.util.Scanner;

final public class View{

    private static ArrayList<MenuActions> menuString = new ArrayList<>();

    public static void addAlgo(MenuActions nameofAlgo){
        menuString.add(nameofAlgo);
    }

    public static void getMenu() {
        System.out.println("0 - exit!");
        for(int i = 0; i < menuString.size(); i++){
            System.out.println(menuString.get(i));
        }
    }

    public static void startMenu(){
        while(true){
            boolean flag = false;
            View.getMenu();
            int input = correctRead();
            if (input == 0) {
                break;
            }
            for(MenuActions x: menuString){
                if (x.getAction() == input){
                    x.doAction();
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println("Sorry, no such action");
            }
        }
    }
    static int correctRead(){
        Scanner read = new Scanner(System.in);
        if(read.hasNextInt()) {
            return read.nextInt();
        }
        else{
            return -1;
        }
    }
}
