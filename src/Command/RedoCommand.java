package Command;

/*
 * Class: RedoCommand
 * @CHOY Ming San
 *
 */

public class RedoCommand implements Command {
    private CareTaker careTaker;

    // constructor
    public RedoCommand(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    // execute redo command
    @Override
    public void execute() {
        careTaker.redo();
    }
}