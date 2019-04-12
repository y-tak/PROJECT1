package lesson12.patterns.dicontainer;

import lesson12.patterns.dicontainer.dir.Configg;
import lesson13.container.Config;

///иинъекции зависимости
@Configg
public class Cat {

    private String catName;

    public Cat() {
        System.out.println("cat init");
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                '}';
    }
}
