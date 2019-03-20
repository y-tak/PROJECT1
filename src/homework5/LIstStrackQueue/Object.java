package homework5.LIstStrackQueue;

public class Object {
    protected int positionStart;
    private Object nextObject;

    public Object() {
        this.positionStart =0;

    }

    public Object(int positionStart, Object nextObject) {
        if (positionStart==0)
        {
            this.positionStart = 1;
            this.nextObject = new Object();
        }
        else
            {
            this.positionStart = positionStart;
            this.nextObject = nextObject;
        }
    }

    public Object getNextObject() {
        return nextObject;
    }

    public void setNextObject(Object nextObject) {
        this.nextObject = nextObject;
    }


    public int getPositionStart() {
        return positionStart;
    }

    public void setPositionStart(int positionStart)
    {
        this.positionStart = positionStart;
    }

    @Override
    public String toString() {
        return "Object [" + positionStart +']';
    }
}
