package Command;

/*
 * Class: ExitCommandFactory
 * @CHOY Ming San
 *
 */

public class ExitCommandFactory implements CommandFactory {
    // create command
    @Override
    public Command createCommand() {
        return new ExitCommand();
    }
}
