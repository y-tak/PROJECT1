package lesson12.patterns.listener;


import java.util.ArrayList;
import java.util.List;

public class NewAgency {

    private List<Listener> listenerList = new ArrayList<>();

    public void addListener(Listener listener) {
        listenerList.add(listener);
    }

    public void deleteListener(Listener listner) {
        listenerList.remove(listner);
    }

    public void someChange(String mes) {
        System.out.println("mes = " + mes);
        notifyListener(mes);
    }

    private void notifyListener(String mes) {
        for (Listener l : listenerList)
            l.publish(mes);
    }

    public static void main(String[] args) {
        NewAgency newAgency = new NewAgency();
        newAgency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("Listner 1 = " + str);
            }
        });
        newAgency.someChange("some change");
        newAgency.someChange("some change1");


    }
}

interface Listener {

    void publish (String str);

}