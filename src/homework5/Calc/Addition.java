package homework5.Calc;

public class Addition implements Execute {
    int value1,value2;

    public Addition(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }


    @Override
    public void excute()
    {
        int s;
        s=this.value1+this.value2;
        System.out.println(this.value1+"+"+this.value2+" = " + s);
    }

    @Override
    public String toString() {
        return "Addition{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}

