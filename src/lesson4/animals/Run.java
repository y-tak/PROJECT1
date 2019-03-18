package lesson4.animals;

////наследование интерфейса
public interface Run extends Runnable,Cloneable ///множественное наследование
{
///описываются методы которые реализовываются в данном классе

    ///начиная с Java 8 версии
    default  public void stop()
    {
        System.out.printf("Стоп");
    }
    public  void run();

}
