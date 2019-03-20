package homework5.LIstStrackQueue;

import homework5.LIstStrackQueue.Object;
import homework5.LIstStrackQueue.Queue;

public class QueueObject extends Object implements Queue
{     public QueueObject() {
    }



    public QueueObject(int positionStart, Object nextObject) {
        super(positionStart, nextObject);
        this.setNextObject(nextObject);
        this.setPositionStart(positionStart);

    }

    @Override
    public String toString() {
        return "Object [" + positionStart +"] "+ this.getNextObject();
    }

    @Override
    public void queue()
    {
        Object enemy=this;
        for (int i=this.positionStart;i>0;i--)
        {
               System.out.println(" запись ["+i+"]: " + enemy);
                enemy=enemy.getNextObject();
        }
        System.out.println(" запись ["+0+"]: " + enemy);

        System.out.println(" Первый в очереди будет запись ["+0+"]: " + enemy);

    }
}
