import java.util.Iterator;

/**
 * Created by Baiye on 04/09/2017.
 */
public class Deque<Item> implements Iterable<Item> {

    private int size;

    private Node<Item> first , last;

    private class Node<Item>
    {
        Item item;
        Node forward;
        Node backward;
    }

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (first == null) {
            first = new Node<Item>();
            first.item = item;
            first.forward = null;
            first.backward = null;
        } else {
            Node<Item> newFirst = new Node<>();
            newFirst.backward = first;
            first.forward = newFirst;
            newFirst.item = item;
            first = newFirst;
            //oldFirst = first;
        }

        if (last == null) {
            Node<Item> temp = first;
            while (temp.backward != null) {
                temp = temp.backward;
            }
            last = temp;
        }

        size++;
    }

    public void addLast(Item item) {
        if (last == null) {
            last = new Node<Item>();
            last.item = item;
            last.forward = null;
            last.backward = null;
        } else {
           Node<Item> newLast = new Node<>();
           newLast.forward = last;
           last.backward = newLast;
           newLast.item = item;
           last = newLast;
        }

        if (first == null) {
            Node<Item> temp = last;
            while (temp.forward != null) {
                temp = temp.forward;
            }
            first = temp;
        }

        size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more items in iteration.");
            }
            Item item = current.item;
            current = current.backward;
            return item;
        }
    }


}
