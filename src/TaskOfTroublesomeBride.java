import java.util.Random;

public class TaskOfTroublesomeBride implements Algorithm {
    @Override
    public String menu() {
        return "to test the “Troublesome Bride Tasks” solution";
    }

    @Override
    public void test() {
        Random random = new Random();
        int n = 100;
        int[] pretenders = new int[n];
        int bestPretender;
        int numberOfBestPretender;
        int numberOfGoodChoices = 0;
        for (int i = 0; i < 1000; i++) {
            pretenders[0] = random.nextInt();
            bestPretender = pretenders[0];
            numberOfBestPretender = 0;
            for (int j = 1; j < n; j++) {
                pretenders[j] = random.nextInt();
                if(pretenders[j] > bestPretender){
                    bestPretender = pretenders[j];
                    numberOfBestPretender = j;
                }
            }
            boolean isBetterThenOthers;
            for(int j = (int)(n/Math.E); j < n; j++){
                isBetterThenOthers = true;
                for(int k = 0; k < j; k++){
                    if(pretenders[k] > pretenders[j]){
                        isBetterThenOthers = false;
                        break;
                    }
                }
                if(isBetterThenOthers){
                    if(j == numberOfBestPretender){
                        numberOfGoodChoices++;
                    }
                    break;
                }
            }
        }
        System.out.println("Chance to choose the best groom: " + numberOfGoodChoices/10 + "%");
    }
}
