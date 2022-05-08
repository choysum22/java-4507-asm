package Command;

/*
 * Class: UndoCommandFactory
 * @CHOY Ming San
 *
 */

public class UndoCommandFactory implements CommandFactory {
    private CareTaker careTaker;

    // constructor
    public UndoCommandFactory(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    // create command
    @Override
    public Command createCommand() {
        return new UndoCommand(this.careTaker);
    }
}
