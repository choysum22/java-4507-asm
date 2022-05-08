package Command;

/*
 * Class: DisplayAllFactoryCommand
 * @CHOY Ming San
 *
 */

import java.util.LinkedList;
import java.util.Scanner;

public class DisplayToyCommandFactory implements CommandFactory {
    private Scanner sc;
    private LinkedList toys;

    // constructor
    public DisplayToyCommandFactory(Scanner sc, LinkedList toys) {
        this.sc = sc;
        this.toys = toys;
    }

    // create command
    @Override
    public Command createCommand() {
        return new DisplayToyCommand(sc, toys);
    }
}
