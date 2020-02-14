import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void print(ArrayList<Algorithm> algorithms){
        System.out.println("Choose an algorithm. Enter: ");
        for(int i = 0; i < algorithms.size(); i++){
            System.out.println(i + " " + algorithms.get(i).menu());
        }
        System.out.println("Enter -1 to exit.");
    }

    private static void testAlgorithms(ArrayList<Algorithm> algorithms){
        boolean isStillWorking = true;
        int k;
        Scanner scanner = new Scanner(System.in);
        do {
            print(algorithms);
            k = scanner.nextInt();
            while (k < -1 || k >= algorithms.size()){
                System.out.println("Wrong input. Try again.");
                k = scanner.nextInt();
            }
            if(k == -1){
                isStillWorking = false;
            } else {
                algorithms.get(k).test();
            }
        } while(isStillWorking);
        scanner.close();
    }

    public static void main(String[] args) {
        ArrayList<Algorithm> algorithms = new ArrayList<>();
        algorithms.add(new MontyHallParadox());
        algorithms.add(new BirthdayParadox());
        algorithms.add(new TaskOfTroublesomeBride());
        testAlgorithms(algorithms);
    }
}
