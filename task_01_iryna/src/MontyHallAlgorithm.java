import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MontyHallAlgorithm extends Algorithm{

    private static final int NUMBER_OF_TRIES = 1000000;
    private List<String> chooses = new ArrayList(Arrays.asList("k", "k", "a"));

    public double countFirstProbability() {
        int winsCounter = 0;
        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            String result1 = getWithoutChange(chooses);
            if (result1.equals("a")) {
                winsCounter++;
            }
        }
        return 1.0 * winsCounter / NUMBER_OF_TRIES;
    }

    public String getWithoutChange(List<String> list) {
        Collections.shuffle(list);
        return list.get((int)Math.floor(Math.random() * list.size()));
    }

    @Override
    public void printResult() {
        double firstProbability = countFirstProbability();
        double secondProbability = 1 - firstProbability;
        System.out.println(firstProbability + " " + secondProbability);
    }

    public void validateNumberOfTries() {
        if (NUMBER_OF_TRIES < 100 && NUMBER_OF_TRIES > 100000) {
            throw new IllegalArgumentException(){

            };
        }
    }

}
