package homework5.List2;

import java.util.Iterator;
import java.util.ListIterator;

public class List2 implements Iterable {

    private Record start;
    Object object;

    ///--------------добавить запись --------------------------
    public void add(int value,Object object) {
        Record findnext;
        if (start == null) {
            start = new Record(value,object);
            return;
        }
        ///----найти послденю щзапись где next=null--------
        find(-1).next = new Record(value,object);
    }



    ///---------------------получить запись------------
    public int get(int idx) {
        Record res = find(idx);
        return res == null ? -1 : res.value;
    }

    public Object getObject()
    {
        return object;
    }


    ////------------------------------удалить запись-----вернуть значение удаляемой строки---------
    public int remove(int idx) {
        ////нет записей - нечего удалить
        if (start == null)
            return -1;
//----есть одна запись возвращаем значение----------
        if (idx == 0) {
            int val = start.value;
            start = start.next;
            return val;
        }
        ///-----------получаем предыдующую запись------------
        Record prev = find(idx - 1);
        if (prev != null) {
            Record cur = prev.next;
            if (cur != null) {
                prev.next = prev.next.next;
                return cur.value;
            }
        }
//-----------иначе возрващать -1
        return -1;
    }

    public Record getStart() {
        return start;
    }

    ///----------------------поиск записи предыдуща яии последующая?---------
    private Record find(int idx) {
        if (idx == 0)
            return start;

        int cnt = 0;

        Record node = start;

        while (node != null) {
            if (cnt++ == idx)
                return node;

            if (idx < 0 && node.next == null)
                return node;

            node = node.next;
        }

        return null;
    }


    @Override
    public Iterator iterator() {
        return new ListIterator(start);
    }

    public class ListIterator implements Iterator {
        Record next;

        public ListIterator(Record next) {
            this.next = next;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            Object cur = next.value;
            Object cur2=next.object;
                    next = next.next;
            return "{"+cur+"}"+"["+cur2+"]";
        }
    }
}

class Record {
    int value;
    Object object;
    Record next;

    public Record(int value,Object object) {
        this.value = value;
        this.object=object;
    }

    public void setNext(Record next)
    {
        this.next = next;
    }
}
