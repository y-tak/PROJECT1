package homework5.Calc;

public class Delete implements Execute {
    int value1,value2;

    public Delete(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public void excute() {
        double s;
        if (this.value2!=0)
        s=this.value1/this.value2;
        else
            s=0;

        System.out.println(this.value1+"/"+this.value2+" = " + s);

    }

    @Override
    public String toString() {
        return "Delete{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
