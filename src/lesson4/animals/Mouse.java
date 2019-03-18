package lesson4.animals;

public class Mouse extends Animals implements Run,Eat{
    @Override
    public void eat(Animals animals)
    {
        System.out.println(animals+"eat ");
    }

    @Override
    public void run() {
    }

    @Override
    public void stop() {
        System.out.printf("Mouse Stop");

    }


}
