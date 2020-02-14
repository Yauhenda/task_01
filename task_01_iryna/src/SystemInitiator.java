public class SystemInitiator {


    public SystemInitiator() {
        Menu mainMenu = new Menu();

        mainMenu.add(new MenuEntry("1","Monty Hall problem") {
            @Override
            public void doAction() {
                MontyHallAlgorithm montyHallAlgorithm = new MontyHallAlgorithm();
                montyHallAlgorithm.printResult();
            }
        });
        mainMenu.add(new MenuEntry("2","Birthday problem") {
            @Override
            public void doAction() {
                BirthdayAlgorithm birthdayAlgorithm = new BirthdayAlgorithm();
                birthdayAlgorithm.printResult();
            }
        });
        mainMenu.add(new MenuEntry("3","Secretary problem") {
            @Override
            public void doAction() {
                System.out.println("Опять чета происходит");
            }
        });
        mainMenu.loopUntilExit();
    }
}
