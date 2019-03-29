package lesson9.collect.enumer;

public enum Planets {
    Pl1(45,654,"Марс"),Pl2(78,654,"Венера"),Pl3(47,98,"Уран");

    int a; int b; String name;

    Planets(int a, int b, String name) {
        this.a = a;
        this.b = b;
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Planets{" +
                "a=" + a +
                ", b=" + b +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }



}

class Plan {
    public static void main(String[] args) {

        System.out.println("Planets= " + Planets.Pl1.getName()+" r  "+ Planets.Pl1.getA()+" rr "+ Planets.Pl1.getB());


    }
}

