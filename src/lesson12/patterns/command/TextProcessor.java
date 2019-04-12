package lesson12.patterns.command;

import java.util.*;

public class TextProcessor {
    private CommandHistory history=new CommandHistory();
   //---добавлено
    private TextHistory textHistory=new TextHistory();


    public static void main(String[] args) {
        TextProcessor textProcessor=new TextProcessor();
        textProcessor.star();
    }

    public CommandHistory getHistory() {
        return history;
    }

    public void  executeCommand(Command command)
    {
        if (command.execute())
       history.add(command);
      ;
    }
//------добавлено для истории записей домашка---------


    public TextHistory getTextHistory() {
        return textHistory;
    }

    public void setTextHistory(TextHistory textHistory) {
        this.textHistory = textHistory;
    }

    ///--------------------------------------------------
    public void star()
    {

        Scanner scanner=new Scanner(System.in);
        while (true)
        {
            System.out.println(" введите данные или команду process/exit/save/delete");
            ///2 команды дописать.
            // добавить данные введенные пользователем - сохранить в историю
            // и отмена -удалить из истории
            ///фабричный метод..создает объекты через метод
            String nameFiles=scanner.nextLine();
            if (nameFiles.equals("process")||nameFiles.equals("exit")||nameFiles.equals("save")||nameFiles.equals("delete"))
            {Command command=Handler.getCommand(nameFiles,this);
            executeCommand(command);}
            else
                textHistory.add(nameFiles);
//---------------------------------переписала под фабричный метод-------------------
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
////---------------история записей---добавлено для домашки----------------
class TextHistory {
    private List<String> list=new LinkedList<>();

    public void add(String string)
    {
        list.add(string);
    }

    public List delete()
    {
        list.clear();
        return list;
    }

    public List<String> getList() {
        return list;
    }


}
///----------------------------------------------------------------------------