package homework5.LIstStrackQueue;

import homework5.LIstStrackQueue.Object;
import homework5.LIstStrackQueue.Strack;

public class StrackObject extends Object implements Strack {

    public StrackObject() {
    }

    public StrackObject(int positionStart, Object nextObject) {
        super(positionStart, nextObject);
        this.setNextObject(nextObject);
        this.setPositionStart(positionStart);

    }

    @Override
    public String toString() {
        return "Object [" + positionStart +"] "+ this.getNextObject();
    }

    @Override
    public void strack() {

        Object enemy=this;

        for (int i=0;i<this.positionStart;i++)
        {
            System.out.println(" запись ["+i+"]: " + enemy);
            enemy=enemy.getNextObject();
        }
        System.out.println(" запись ["+this.positionStart+"]: " + enemy);
        System.out.println(" Первый в стекe  будет запись ["+0+"]: " +this);

    }
}
