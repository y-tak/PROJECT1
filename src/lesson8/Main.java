package lesson8;

public class Main {
    public static void main(String[] args) {

        Book tain = new Book("tain", 34);
        Book flower = new Book("flower", 54);

        Car car = new Car("red");

//        LinkedList bookStoreg=new LinkedList();
//        bookStoreg.add(tain);
//        bookStoreg.add(flower);
//
//        bookStoreg.add(car);
//
//        ///Object bookFromStorag1= bookStoreg.get(0);
//   ////нет gettatle()
//        Book bookFromStorag2= (Book) bookStoreg.get(1); //приведение типа
//        Book bookFromStorag1= (Book) bookStoreg.get(0); //приведение типа
//        System.out.println(bookFromStorag1);
//        System.out.println(bookFromStorag2);
//
//
//
//        Car bookFromStorag3= (Car) bookStoreg.get(2); //приведение типа
//        System.out.println(bookFromStorag3);

        LinkedList<Book> bookLinkedList = new LinkedList<>();
        bookLinkedList.add(tain);
        bookLinkedList.add(flower);

        System.out.println(bookLinkedList.get(0));

//
        LinkedList<Car> carLinkedList = new LinkedList<>();
        carLinkedList.add(car);
        System.out.println(carLinkedList.get(0).color);


        LinkedList<ChildBook> childBookLinkedList = new LinkedList<>();
        ChildBook childBook = new ChildBook("child drawing", 47);
        childBookLinkedList.add(childBook);

        Book book = getFirstBook(childBookLinkedList);
        Book book3 = getFirstBook1(childBookLinkedList);
        System.out.println(book3);

       addToStorage(bookLinkedList);

    }

    ////---со всеми потомками--добавить <? extends Имя Класса>
    public static Book getFirstBook(LinkedList<? extends Book> storege) {
//        ChildBook book=new ChildBook("hjhgs",98);
//        storege.add(book);

        return storege.get(0);
    }

    public static ChildBook getFirstBook1(LinkedList<? extends Book> storege) {
        return (ChildBook) storege.get(0);
    }
    ///класс Book и все его предки <? super Book>
    public static void addToStorage(LinkedList<? super Book> storage) {
        Book book = new Book("king", 7);
        storage.add(book);///BOOK

        ChildBook childBook = new ChildBook("king", 77);
        storage.add(childBook);///ChildBook

        //  Book book1=storage.get(0);

        Object o = storage.get(0);
        System.out.println("1 "+o);
        Object o1 = storage.get(1);
        System.out.println("2 "+o1);


    }

    //public void someVoid(LinkedList<String> storage){}
    //public void someVoid(LinkedList<Integer> storage){}
    //public static T staticVoid(){}


    public static void storage(LinkedList<?> storage) {
        Book book = new Book("jkhk", 4);
        //Object object=new Object();
        //storage.add(object);

        ///storage.add(book)
        storage.add(null);

        ///  Book book1=storage.get(0);
        Object o = storage.get(0);
    }
}