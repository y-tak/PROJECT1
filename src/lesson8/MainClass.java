package lesson8;

public class MainClass
{
    public void someVoid2()
    {
        int a=14; //stack+ссылка на String
    String str ="String";//--heap
    }
    public void someVoid()
    {int b=12;
        someVoid2();
    }

    //потоки работают с HEAP  и под каждый потом создается Stack
    ///все потоки работают c Hеap

    ///Инкапсуляция
    ///Наследование
    ///Полиморфизм
    ///абстракция




////последователььное выделение памяти Stack Пямять
    public static void main(String[] args) {
        MainClass mainClass=new MainClass();
        mainClass.someVoid();

    }
}
