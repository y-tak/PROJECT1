package lesson8;

public class Pair<K,V>
{
    private K key;
    private V value;

    public Pair() {
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Pair<Integer,String> pair1=new Pair<>();
        pair1.setKey(2);
        pair1.setValue("fkfdlkfjd");

        Pair<Integer,String> pair=new Pair<>(2,"dsdf");
        System.out.println(pair);

    }



}
