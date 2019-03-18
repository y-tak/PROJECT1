package lesson4.animals;
//dв это классе можно описывать методы с реализацией и не с реализацией
public abstract class AbstractClass {
    public abstract void abstrackMetod();
        public void SomeVoid()
        {
            System.out.printf("someVoid");
        }
}

interface SomeInterface{
    public void iVoid();

}

class SomeClass extends AbstractClass {
    @Override
    public void abstrackMetod() {
        System.out.println("Реализация метода абстрактного класса");
    }



}