package View;

import Algorithms.BirthdayAlgorithm;
import Algorithms.MontyHallAlgorithm;
import Algorithms.SecretaryAlgorithm;
import View.Menu;
import View.MenuEntry;

public class SystemInitiator {


    public SystemInitiator() {
        Menu mainMenu = new Menu();

        addFirstMenu(mainMenu);
        addSecondMenu(mainMenu);
        addThirdMenu(mainMenu);
        mainMenu.loopUntilExit();
    }

    public void addFirstMenu(Menu menu) {
        menu.add(new MenuEntry("1", "Monty Hall problem") {
            @Override
            public void doAction() {
                MontyHallAlgorithm montyHallAlgorithm = new MontyHallAlgorithm();
                montyHallAlgorithm.validateNumberOfTries();
                montyHallAlgorithm.printResult();
            }
        });
    }

    public void addSecondMenu(Menu menu) {
        menu.add(new MenuEntry("2", "Birthday problem") {
            @Override
            public void doAction() {
                BirthdayAlgorithm birthdayAlgorithm = new BirthdayAlgorithm();
                birthdayAlgorithm.printResult();
            }
        });
    }

    public void addThirdMenu(Menu menu) {
        menu.add(new MenuEntry("3", "Secretary problem") {
            @Override
            public void doAction() {
                SecretaryAlgorithm secretaryAlgorithm = new SecretaryAlgorithm();
                secretaryAlgorithm.printResult();
            }
        });
    }
}
