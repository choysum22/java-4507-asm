package Command;

/*
 * Class: DisplayCommandFactory
 * @CHOY Ming San
 *
 */

import java.util.Stack;

public class DisplayCommandFactory implements CommandFactory {
    private Stack<String> undoCommand;
    private Stack<String> redoCommand;

    // constructor
    public DisplayCommandFactory(Stack undoCommand, Stack redoCommand) {
        this.undoCommand = undoCommand;
        this.redoCommand = redoCommand;
    }

    // create command
    @Override
    public Command createCommand() {
        return new DisplayCommand(undoCommand, redoCommand);
    }
}
