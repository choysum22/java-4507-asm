package Command;

/*
 * Class: CreateToyCommand
 * @CHOY Ming San
 *
 */

import Toy.RemoteControlCarFactory;
import Toy.RobotFactory;
import Toy.ToyFactory;
import Toy.ToyProduct;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CreateToyCommand implements Command {
    private final String ROBOT = "ro";
    private final String REMOTECONTROLCAR = "rc";
    private LinkedList toys;
    private Scanner sc;
    private ToyFactory toyFactory;
    private ToyProduct toy;
    private CareTaker careTaker;
    private Stack<String> undoCommand;

    // constructor
    public CreateToyCommand(Scanner sc, LinkedList toys, CareTaker careTaker, Stack undoCommand) {
        this.sc = sc;
        this.toys = toys;
        this.careTaker = careTaker;
        this.undoCommand = undoCommand;
    }

    // execute create toy command
    @Override
    public void execute() {
        System.out.println("Creating New toy product record...\n");
        while (true) {

            System.out.println("Enter toy type (ro=Robot/rc=Remote Control Car):");
            // prompt user input
            String type = sc.nextLine();
            if (type.equals(ROBOT)) { // if user inputted "ro", create an robot toy
                toyFactory = new RobotFactory();
                toy = toyFactory.createToy(sc, toys);
                toys.add(toy);

                // push created toy object into stack for undo command
                careTaker.createToy(toy, true);

                // add command to undo list
                undoCommand.push("Create " + toy.getProductID() + " " + toy.getName());
                break;
            } else if (type.equals(REMOTECONTROLCAR)) { // if user inputted "rc", create an remote car toy
                toyFactory = new RemoteControlCarFactory();
                toy = toyFactory.createToy(sc, toys);
                toys.add(toy);

                // push created toy object into stack for undo command
                careTaker.createToy(toy, true);

                // add command to undo list
                undoCommand.push("Create " + toy.getProductID() + " " + toy.getName());
                break;
            } else { // if user inputted neither "ro" or "rc", display error message and continue loop
                System.out.println("Invalid Input. Usage: [rc/ro]");
            }

        }
    }
}
