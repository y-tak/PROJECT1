package lesson4.animals;


public class Cats extends Animals implements Run,Eat

{
    @Override
    public void run(){
        System.out.println("run ");
    }


    @Override
    public void eat(Animals animals) {
        System.out.println("eat");

    }

    @Override
    public void stop() {
        System.out.printf("Cats Stop");
    }
}
