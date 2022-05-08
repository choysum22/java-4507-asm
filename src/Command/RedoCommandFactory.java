package Command;

/*
 * Class: RedoCommandFactory
 * @CHOY Ming San
 *
 */

public class RedoCommandFactory implements CommandFactory {
    private CareTaker careTaker;

    // constructor
    public RedoCommandFactory(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    // create command
    @Override
    public Command createCommand() {
        return new RedoCommand(this.careTaker);
    }
}
