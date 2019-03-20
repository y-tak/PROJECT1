package homework5.LIstStrackQueue;

public class ListObject extends Object implements List {
    public ListObject() {
    }

    public ListObject(int positionStart, Object nextObject) {
        super(positionStart, nextObject);

        this.setNextObject(nextObject);
        this.setPositionStart(positionStart);

    }

    @Override
    public String toString()
    {

        return "Object [" + positionStart +"] ";
    }



    @Override
    public void list() {
///---организованный вывод
        System.out.print(" запись ");
        for (int j = 0; j < this.getPositionStart(); j++)        {
            Object enemy = this;
            for (int i = j; i < this.getPositionStart(); i++)
            { enemy = enemy.getNextObject();}

            System.out.print(" " +enemy);
        }
        System.out.print(" " +this);

    }

}
