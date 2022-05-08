/*
 * Class: Main
 * @CHOY Ming San
 *
 */

import Command.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList toys = new LinkedList(); // a linked list to store all toys
        Stack<String> undoCommand = new Stack(); // a stack to store all undo commands
        Stack<String> redoCommand = new Stack(); // a stack to store all redo commands
        CareTaker careTaker = new CareTaker(toys, undoCommand, redoCommand); // a caretaker to handle memento for undo and redo

        // using a HashMap to store the command factories
        HashMap<String, CommandFactory> f = new HashMap<>();
        f.put("c", new CreateToyCommandFactory(sc, toys, careTaker, undoCommand));
        f.put("d", new DisplayToyCommandFactory(sc, toys));
        f.put("p", new PurchaseCommandFactory(sc, toys, careTaker, undoCommand));
        f.put("s", new SellCommandFactory(sc, toys, careTaker, undoCommand));
        f.put("u", new UndoCommandFactory(careTaker));
        f.put("r", new RedoCommandFactory(careTaker));
        f.put("l", new DisplayCommandFactory(undoCommand, redoCommand));
        f.put("x", new ExitCommandFactory());

        // command operation by user
        while (true) {
            try {
                System.out.println(
                        "\nToy Inventory Management System (TIMS)\n" +
                                "Please enter command: [c | d | p | s | u | r | l | x]\n" +
                                "c = create toy, d = display toy, p = purchase toy, s = sell toy,\n" +
                                "u = undo, r = redo, l = list undo/redo, x = exit system\n");
                Command cmd = f.get(sc.nextLine()).createCommand();
                cmd.execute();
            } catch (Exception e) { // catch invalid input and let user try again
                System.out.println("Invalid Input. Please try again. Usage: [c | d | p | s | u | r | l | x]");
            }
        }
    }

}
