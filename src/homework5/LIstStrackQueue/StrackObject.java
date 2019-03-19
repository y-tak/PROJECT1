package homework5.LIstStrackQueue;

import homework5.LIstStrackQueue.Object;
import homework5.LIstStrackQueue.Strack;

public class StrackObject extends Object implements Strack {

 private Object object;

    public StrackObject(Object object) {
        this.object = object;
    }

    public StrackObject(int position, Object object) {
        super(position);
        this.object = object;
    }




    @Override
    public void strack() {


    }
}
