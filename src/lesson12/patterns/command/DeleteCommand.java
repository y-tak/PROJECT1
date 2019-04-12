package lesson12.patterns.command;

import java.util.LinkedList;
import java.util.List;

public class DeleteCommand extends Command implements Handler
{
    @Override
    String name() {
        return "delete";
    }

    @Override
    boolean execute() {

        List<String> list=new LinkedList<>();
        list=processor.getTextHistory().delete();
        System.out.println("execute delete: list = " + list);
        return true;
    }

    public DeleteCommand(TextProcessor processor) {
        super(processor);
    }
}
