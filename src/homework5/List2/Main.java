package homework5.List2;

public class Main {

    public static void main(String[] args) {

        System.out.println("Примеры работы LIST со списком добавить и удалить");
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
        System.out.println("---------------------------------------------------");
        System.out.println("----------------------Новый список--------------- ");

       RecodrNote recodrNote=new RecodrNote();
        recodrNote.add(3,"a");
        recodrNote.add(4,"b");
        recodrNote.add(5,"c");
        recodrNote.add(6,"d");
        recodrNote.add(7,"e");
        recodrNote.add(8,"f");
        for (Object o: recodrNote)
        {
            System.out.println(o);
        }

        System.out.println("добавим элемент {9} [g] ");
        System.out.println("Пример QUEU Первым вошел --> первым вышел ");
        recodrNote.queuqeue(9,"g");

        for (Object o: recodrNote)
        {
            System.out.println(o);
        }

        System.out.println("Пример STACK Первым вошел --> последним вышел ");
        RecodrNote recodrNote1=new RecodrNote();
        recodrNote1.add(3,"a");
        recodrNote1.add(4,"b");
        recodrNote1.add(5,"c");
        recodrNote1.add(6,"d");
        recodrNote1.add(7,"e");
        recodrNote1.add(8,"f");
        recodrNote1.strackstrack(9,"g");
        for (Object o: recodrNote1)
        {
            System.out.println(o);
        }
    }
}
