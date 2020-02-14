public class BirthdayAlgorithm extends Algorithm{
    private static final int DAYS_IN_A_YEAR = 366;
    private static final int NUMBER_OF_PEOPLE = 23;

    public double getResult() {
        double k = 1.0;

        for ( int i = DAYS_IN_A_YEAR - NUMBER_OF_PEOPLE; i <= DAYS_IN_A_YEAR - 1; i++ ) {
            k = k * i;
            k = k / 365;
        }

        return 100 * ( 1 - k );
    }

    public void printResult() {
        System.out.println(getResult());
    }
}
