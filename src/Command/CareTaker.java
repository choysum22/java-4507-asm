package Command;

/*
 * Class: CareTaker
 * @CHOY Ming San
 *
 */

import Toy.ToyProduct;

import java.util.LinkedList;
import java.util.Stack;

public class CareTaker {
    private LinkedList toys;
    private Stack<String> undoCommand;
    private Stack<String> redoCommand;
    private Stack undo;
    private Stack redo;

    // constructor
    public CareTaker(LinkedList toys, Stack undoCommand, Stack redoCommand) {
        this.toys = toys;
        this.undoCommand = undoCommand;
        this.redoCommand = redoCommand;
        this.undo = new Stack();
        this.redo = new Stack();
    }

    // undo command
    public void undo() {
        // check for empty undo
        if (!undo.isEmpty()) {
            Object undoObject = this.undo.pop();
            if (undoObject instanceof ToyProduct) { // undo create new toy
                this.redo.add(undoObject);
                this.toys.remove(undoObject);
            } else if (undoObject instanceof Memento) { // undo sell or purchase toy
                this.rememberRedo(((Memento) undoObject).getToyProduct());
                ((Memento) undoObject).restore();
            }
            System.out.println("Undo completed.");
            redoCommand.push(undoCommand.pop()); // move command from undo list to redo list
        } else {
            System.out.println("There is nothing to undo");
        }
    }

    // redo command
    public void redo() {
        // check for empty redo
        if (!redo.isEmpty()) {
            Object redoObject = this.redo.pop();
            if (redoObject instanceof ToyProduct) { // redo create new toy
                this.createToy(redoObject, false);
                this.toys.add(redoObject);
            } else if (redoObject instanceof Memento) { // redo sell or purchase toy
                this.remember(((Memento) redoObject).getToyProduct(), false);
                ((Memento) redoObject).restore();
            }
            System.out.println("Redo completed.");
            undoCommand.push(redoCommand.pop()); // move command from redo list to undo list
        } else {
            System.out.println("There is nothing to redo");
        }
    }

    // clear redo stack
    public void clearRedo() {
        this.redo.clear();
        this.redoCommand.clear();
    }

    // remember a state of a toy object
    public void remember(ToyProduct object, boolean clearRedo) {
        undo.push(new Memento(object));
        if (clearRedo)
            this.clearRedo();
    }

    // remember a state of a toy object for redo purposes
    public void rememberRedo(ToyProduct object) {
        this.redo.push(new Memento(object));
    }

    // push created toy object into stack for undo command
    public void createToy(Object object, boolean clearRedo) {
        this.undo.push(object);
        if (clearRedo)
            this.clearRedo();
    }

}
