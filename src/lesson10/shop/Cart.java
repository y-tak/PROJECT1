package lesson10.shop;

import java.util.ArrayList;

public class Cart
{
    private  ArrayList<Good> goodArrayList=new ArrayList<>();

    public void addGood(Good good)
{
    goodArrayList.add(good);
}

    public void removeGood(Good good)
    {
        goodArrayList.remove(good);
    }

    public double getSumm()
    {
        double sum=0;
        for (Good g:goodArrayList ) {
            sum=sum+g.price;

        }
        return sum;
    }

}
