package Command;

/*
 * Class: DisplayCommand
 * @CHOY Ming San
 *
 */

import java.util.Stack;

public class DisplayCommand implements Command {
    private Stack<String> undoCommand;
    private Stack<String> redoCommand;

    // constructor
    public DisplayCommand(Stack undoCommand, Stack redoCommand) {
        this.undoCommand = undoCommand;
        this.redoCommand = redoCommand;
    }

    // execute display command list command
    @Override
    public void execute() {
        System.out.println("Undo List:");
        if (!undoCommand.isEmpty()) { // check for empty stack
            for (String s : undoCommand) {
                System.out.println(s);
            }
        }
        System.out.println("\nRedo List:");
        if (!redoCommand.isEmpty()) { // check for empty stack
            for (String s : redoCommand) {
                System.out.println(s);
            }
        }
    }
}
