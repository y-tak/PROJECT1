package homework5.LIstStrackQueue;

public class Object {
    int position;

    public Object() {
    }

    public Object(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Object{" + "position=" + position +'}';
    }
}
