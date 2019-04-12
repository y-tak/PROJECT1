package lesson12.patterns.command;

public class ExitCommand extends Command
{
    @Override
    String name() {
        return "exit";
    }

    @Override
    boolean execute() {

        //---выход из программы
        System.out.println(" exit process");
        return true;
    }

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }
}
