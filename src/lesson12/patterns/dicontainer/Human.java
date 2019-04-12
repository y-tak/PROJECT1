package lesson12.patterns.dicontainer;

import lesson12.patterns.dicontainer.dir.AutoField;
import lesson12.patterns.dicontainer.dir.AutoRun;
import lesson12.patterns.dicontainer.dir.Component;

@Component
public class Human {
    @AutoField
    Cat cat;
    Dog dog;


    public Human() {
        System.out.println("human init ");
    }

    @AutoRun
    public  void  walkWithCat()
    {
        System.out.println("walk With "+cat.getCatName() );    }

}
