package Command;

/*
 * Class: SellCommandFactory
 * @CHOY Ming San
 *
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SellCommandFactory implements CommandFactory {
    private Scanner sc;
    private LinkedList toys;
    private CareTaker careTaker;
    private Stack<String> undoCommand;

    //constructor
    public SellCommandFactory(Scanner sc, LinkedList toys, CareTaker careTaker, Stack undoCommand) {
        this.sc = sc;
        this.toys = toys;
        this.careTaker = careTaker;
        this.undoCommand = undoCommand;
    }

    // create command
    @Override
    public Command createCommand() {
        return new SellCommand(sc, toys, careTaker, undoCommand);
    }
}
