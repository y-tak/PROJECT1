package homework5.Calc;

public class Multiplication implements Execute{
    int value1,value2;

    public Multiplication(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public void excute() {

        int s;
        s=this.value1*this.value2;
        System.out.println(this.value1+"*"+this.value2+" = " + s);
    }

    @Override
    public String toString() {
        return "Multiplication{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
