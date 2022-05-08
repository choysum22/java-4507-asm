package Command;

/*
 * Class: UndoCommand
 * @CHOY Ming San
 *
 */

public class UndoCommand implements Command {
    private CareTaker careTaker;

    // constructor
    public UndoCommand(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    // execute undo command
    @Override
    public void execute() {
        careTaker.undo();
    }
}
