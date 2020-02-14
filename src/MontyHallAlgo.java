import java.util.Random;
import java.util.Scanner;

public class MontyHallAlgo{

    public static void startAlgo() {
        consoleOut();
        int numOfExperiment;
        numOfExperiment = checkRead(correctRead(), 0, 10000000);
        writeAns(experiment(numOfExperiment), numOfExperiment);
    }
    private static void consoleOut(){
        System.out.println("Enter the number of experiment, but not more than 10000000");
    }
    private static int correctRead(){
        Scanner read = new Scanner(System.in);
        if (read.hasNextInt()) {
            return read.nextInt();
        }
        else {
                return 0;
        }
    }

    private static int checkRead(int num, int l, int r){
        if (num < l || num > r)
            return 0;
        else
            return num;
    }

    private static int rand(int n){
        Random r = new Random();
        return r.nextInt(n);
    }

    private static int experiment(int num){
        int ans = 0;
        for (int i = 0; i < num; i++){
            int winningDoor = rand(3);
            int uDoor = rand(3);
            if (winningDoor == uDoor)
                ans++;
        }
        return ans;
    }
    private static void writeAns(int ans, int num){
        if (num == 0){
            System.out.println("Incorrect input");
        }
        else {
            System.out.println("when we change the door - " + ans + " win out of " + num);
            System.out.println("when we do not change the door - " + (num - ans) + " win out of " + num);
        }
    }
}
