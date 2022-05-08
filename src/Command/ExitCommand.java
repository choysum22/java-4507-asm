package Command;

/*
 * Class: ExitCommand
 * @CHOY Ming San
 *
 */

public class ExitCommand implements Command {
    // execute exit command
    @Override
    public void execute() {
        System.out.println("Exit...");
        System.exit(0);
    }
}
