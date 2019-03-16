package homework4;

public class Dogs {

    String name;
    double ves;
    int age;
    String color;
    String adress;



    public Dogs(String name)
    {
        this.name = name;
        this.ves= 3.5;

    }

    public Dogs(String name, double ves, int age)
    {
        this.name = name;

        if (ves!=0)
            this.ves= 3.5;
        else
            this.ves= ves;

        this.age = age;
    }
    public Dogs(String name, int age)
    {
        this.ves= 3.5;
        this.name = name;
        this.age = age;
    }
    public Dogs( double ves,  String color)
    {
        if (ves!=0)
            this.ves= 3.5;
        else
            this.ves= ves;
        this.color = color;
    }
    public Dogs( double ves,  String color,String adress)
    {
        if (ves!=0)
            this.ves= 3.5;
        else
             this.ves= ves;

        this.color = color;
        this.adress = adress;
    }



    public void setVes(double ves)
    {

        this.ves = ves;
    }



    @Override
    public String toString() {
        return "Dogs{" +
                "name='" + name + '\'' +
                ", ves=" + ves +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
