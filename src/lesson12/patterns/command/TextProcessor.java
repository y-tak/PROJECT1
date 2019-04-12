package lesson12.patterns.command;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TextProcessor {
    private CommandHistory history=new CommandHistory();

    public static void main(String[] args) {
        TextProcessor textProcessor=new TextProcessor();
        textProcessor.star();
    }

    public void  executeCommand(Command command)
    {
        if (command.execute())
       history.add(command);
    }


    public void star()
    {

        Scanner scanner=new Scanner(System.in);
        while (true)
        {
            System.out.println(" введите команду process/exit/save/delete");
            ///2 команды дописать.
            // добавить данные введенные пользователем - сохранить в историю
            // и отмена -удалить из истории
            ///фабричный метод..создает объекты через метод
            String nameFiles=scanner.nextLine();
            Command command=Handler.getCommand(nameFiles,this);
            executeCommand(command);
//
//            switch (scanner.nextLine())
//            { case "process":
//                executeCommand(new ProcessComand(this));
//                break;
//                case "exit":
//                    executeCommand(new ExitCommand(this));
//                    break;
//
//
//            }
        }

    }

}

class CommandHistory
{
    private Stack<Command> history = new Stack<>();

    public void add(Command command)
    {
        history.push(command);
    }

    public Command delete()
    {
        return  history.pop();
    }

    public boolean isEmpty()
    {
     return history.isEmpty();
    }


}