package homework4;

public class Cats {
    int age;
    int power;
    int ves;

    public Cats(int age, int power, int ves) {
        this.age = age;
        this.power = power;
        this.ves = ves;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "age=" + age +
                ", power=" + power +
                ", ves=" + ves +
                '}';
    }

    public boolean fight(Cats cat2) {
        int age1,age2,age11,age21;
        int power1,power2;
        int ves1,ves2;
        int s1,s2;
        boolean victory=true;

        age1=this.age;
        age2=cat2.age;
        power1= this.power;
        power2= cat2.power;
        ves1=this.ves;
        ves2=cat2.ves;


         if (age1>5)  age11=age1-(age1-5);
         else age11=age1;
        if (age2>5)  age21=age2-(age2-5);
        else age21=age2;
        s1=age11+power1+ves1;
        s2=age21+power2+ves2;

      return s1<s2;
        ///if (s1>s2) victory=true;
     ///  else victory=false;
       // return victory;

    }
}
