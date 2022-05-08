package Command;

/*
 * Class: CreateToyCommandFactory
 * @CHOY Ming San
 *
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CreateToyCommandFactory implements CommandFactory {
    private Scanner sc;
    private LinkedList toys;
    private CareTaker careTaker;
    private Stack<String> undoCommand;

    // constructor
    public CreateToyCommandFactory(Scanner sc, LinkedList toys, CareTaker careTaker, Stack undoCommand) {
        this.sc = sc;
        this.toys = toys;
        this.careTaker = careTaker;
        this.undoCommand = undoCommand;
    }

    // create command
    @Override
    public Command createCommand() {
        return new CreateToyCommand(sc, toys, careTaker, undoCommand);
    }
}
