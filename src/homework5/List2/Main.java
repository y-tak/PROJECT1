package homework5.List2;

public class Main {

    public static void main(String[] args) {

       List2 list = new List2();

        list.add(3,"a");
        list.add(45,"b");
        list.add(6,"c");
        list.add(454,"d");
        list.add(65,"e");

        for (Object o: list)
        {
            System.out.println(o);
        }
        System.out.println("Удалим 65--4 индекс");
        list.remove(4);


        for (Object o: list)
        {
            System.out.println(o);
        }
        System.out.println("-----------------");
       RecodrNote recodrNote=new RecodrNote();
        recodrNote.add(3,"a");
        recodrNote.add(4,"b");
        recodrNote.add(5,"c");
        recodrNote.add(6,"d");
        recodrNote.add(7,"e");
        recodrNote.add(8,"f");
        //recodrNote.queuqeue();
        for (Object o: recodrNote)
        {
            System.out.println(o);
        }



    }
}
