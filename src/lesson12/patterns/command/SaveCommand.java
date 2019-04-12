package lesson12.patterns.command;

import java.util.*;

public class SaveCommand extends Command implements Handler {

    public SaveCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "save";
    }

    @Override
    boolean execute() {

        List<String> list=new LinkedList<>();
        list=processor.getTextHistory().getList();
        System.out.println("execute save: list = " + list);

        return true;
    }
}
