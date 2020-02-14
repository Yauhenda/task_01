import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class SecretaryProblemAlgo {

    public static void startAlgo() {
        consoleOut();
        int numOfExperiment, numOfBridegroom, numOfPeopleMiss;
        numOfExperiment = checkRead(correctRead(), 1, 10000000);
        numOfBridegroom = checkRead(correctRead(), 2, 100000);
        numOfPeopleMiss = checkRead(correctRead(), 1, numOfBridegroom);
        writeAns(experiment(numOfExperiment, numOfBridegroom, numOfPeopleMiss), numOfExperiment, numOfPeopleMiss, numOfBridegroom);
    }
    private static void consoleOut(){
        System.out.println("Enter the number of experiment, but not more than 10000000 and enter the number of bridegroom and how many people will miss");
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
        if (num < l || num >= r)
            return 0;
        else
            return num;
    }

    private static int rand(int n){
        Random r = new Random();
        return r.nextInt(n);
    }

    private static int experiment(int num, int groom, int peop){
        int ans = 0;
        for (int i = 0; i < num; i++) {
            ArrayList<Integer> grooms = new ArrayList<Integer>();
            for (int j = 0; j < groom; j++){
                grooms.add(j, j);
            }
            Collections.shuffle(grooms);
            int ind = peop;
            for (int j = peop + 1; j < groom; j++){
                if (grooms.get(j) > grooms.get(j - 1)) {
                    ind = j;
                    break;
                }
            }
            if (ind == groom) {
                ind--;
            }
            ans += (grooms.get(ind) + 1);
        }
        return ans;
    }

    private static void writeAns(int ans, int num, int peop, int groom){
        if (num == 0 || peop == 0 || groom == 0){
            System.out.println("Incorrect input");
        }
        else {
            System.out.println("Approximate rating " + ((double)ans/num) + " of " + groom + " Bridegroom");
        }
    }
}
