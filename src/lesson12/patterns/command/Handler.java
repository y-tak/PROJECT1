package lesson12.patterns.command;

public interface Handler {

    public static Command getCommand(String nameCommand,TextProcessor textProcessor)
    {
        Command command=new Command(textProcessor) {
            @Override
            String name() {
                return null;
            }

            @Override
            boolean execute() {
                return false;
            }
        };

        if (nameCommand.equals("process")) {
           command = new ProcessComand(textProcessor);
        } else if (nameCommand.equals("exit")) {
            command = new ExitCommand(textProcessor);

        }
        return command;
    }
}
