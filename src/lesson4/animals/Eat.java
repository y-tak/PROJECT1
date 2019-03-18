package lesson4.animals;

public interface Eat {
    public void eat(Animals animals);

    default  public void stop()
    {
        System.out.printf("Стоп");
    }
}
