package lesson12.patterns.dicontainer;

import lesson12.patterns.dicontainer.dir.Container;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ArrayList<Class> classes=new ArrayList<>();
        classes.add(Cat.class);
        classes.add(Dog.class);
        classes.add(Human.class);

        new Container(classes).start();

    }
}
