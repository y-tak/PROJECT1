package lesson8;

import java.util.Iterator;


public class LinkedList <T> {
    private Node<T> head;

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);

            return;
        }

        find(-1).next = new Node<>(value);
    }

    public T get(int idx) {
        Node<T> res = find(idx);

        return res == null ? null : res.value;
    }

    public Object remove(int idx) {
        if (head == null)
            return -1;

        if (idx == 0) {
            Object val = head.value;
            head = head.next;

            return val;
        }

        Node prev = find(idx - 1);

        if (prev != null) {
            Node cur = prev.next;

            if (cur != null) {
                prev.next = prev.next.next;

                return cur.value;
            }
        }

        return -1;
    }

    private Node find(int idx) {
        if (idx == 0)
            return head;

        int cnt = 0;

        Node node = head;

        while (node != null) {
            if (cnt++ == idx)
                return node;

            if (idx < 0 && node.next == null)
                return node;

            node = node.next;
        }

        return null;
    }

//
//    @Override
//    public Iterator iterator() {
//        return new ListIterator(head);
//    }
//
//    private class ListIterator implements Iterator{
//        Node next;
//
//        public ListIterator(Node node) {
//            this.next = node;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return next != null;
//        }
//
//        @Override
//        public Object next() {
//            Object cur = next.value;
//            next = next.next;
//            return cur;
//        }
//
//
//
//    }
}

///Genery не понятный тип
class Node <T>{
    T value;
////Т- ссылочны объект
    Node next;

    public Node(T value) {
        this.value = value;
    }
}
