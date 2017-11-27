package zaltys.commands;

public class ExitCommand implements CommandInterface {
    @Override
    public void execute() {
        System.exit(0);
    }
}
