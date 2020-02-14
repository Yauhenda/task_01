public class MontyHallParadox implements Algorithm {

    @Override
    public String menu() {
        return "to test the monty hall paradox";
    }

    @Override
    public void test() {
        int wonByChangingDoor = 0, wonByNotChangingDoor = 0;
        for (int i = 0; i<1000; i++) {
            int doorWithCar = (int) (Math.random() * 3);
            int chosenDoor = (int) (Math.random() * 3);
            if (chosenDoor == doorWithCar) {
                wonByNotChangingDoor++;
            } else {
                wonByChangingDoor++;
            }
        }
        System.out.println("Chance to win without choosing another door: " + wonByNotChangingDoor/10 + "%" +
                "\nChance to win by choosing another door: " + wonByChangingDoor/10 + "%" );
    }
}
