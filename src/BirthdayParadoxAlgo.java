import java.util.Random;
import java.util.Scanner;

public class BirthdayParadoxAlgo {

    public static void startAlgo() {
        consoleOut();
        int numOfExperiment, numOfPeople;
        numOfExperiment = checkRead(correctRead(), 1, 10000000);
        numOfPeople = checkRead(correctRead(), 2, 365);
        writeAns(experiment(numOfExperiment, numOfPeople), numOfExperiment, numOfPeople);
    }

    private static void consoleOut(){
        System.out.println("Enter the number of experiment, but not more than 10000000 and enter the number of people [2..365]");
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

    private static int experiment(int num, int peop){
        int ans = 0;
        for (int i = 0; i < num; i++){
            int[] date = new int[365];
            for (int j = 0; j < peop; j++) {
                int r = rand(365);
                if (date[r] == 1) {
                    ans++;
                    break;
                } else {
                    date[r]++;
                }
            }
        }
        return ans;
    }

    private static void writeAns(int ans, int num, int peop){
        if (num == 0 || peop == 0){
            System.out.println("Incorrect input");
        }
        else {
            System.out.println("In a group of " + peop + " people, when experimented " + num + " times the birthdays coincided " + ans);
        }
    }
}
