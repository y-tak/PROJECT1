package lesson12.patterns.command;

public class ProcessComand extends Command {
    @Override
    String name() {
        return "Process";
    }

    @Override
    boolean execute() {
        //--добавление данных
        System.out.println(" execute process" );
        return true;
    }

    public ProcessComand(TextProcessor processor) {
        super(processor);
    }
}
