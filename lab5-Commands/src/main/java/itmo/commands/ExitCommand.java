package itmo.commands;


/**
 * complete the program
 */
public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
