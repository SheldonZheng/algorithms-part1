package week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Baiye on 07/09/2017.
 */
public class RandomizedQueue<Item> implements Iterable<Item>{

    private int size;

    private int cap;

    private Item[] items;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size = 0;
        cap = 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resizeUp() {
        cap *= 2;
        if (cap == 0) {
            cap = 1;
        }
        Item[] newItems = (Item[]) new Object[cap];
        //for (int i = 0; i < items.length ; i++) {
        //    newItems[i] = items[i];
        //}
        int index = 0;
        for (Item item : items) {
            newItems[index++] = item;
        }
        items = newItems;
    }

    private void resizeDown() {
        cap = size / 2;
        if (cap == 0) {
            cap = 1;
        }
        Item[] newItems = (Item[]) new Object[cap];
        for (int i = 0; i < cap ; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }


    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null Item");
        }
        if (size + 1 > cap) {
            resizeUp();
            items[size] = item;
        } else {
            items[size] = item;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Cannot dequeue from an empty week2.RandomizedQueue");
        }
        int randIndex = StdRandom.uniform(size);
        Item item = items[randIndex];
        if (randIndex == (size - 1)) {
            items[size - 1] = null;
        } else {
            items[randIndex] = items[size - 1];
            items[size - 1] = null;
        }
        size--;
        if (size < cap / 4) {
           resizeDown();
        }

        return item;
    }

    public Item sample() {
        if(isEmpty())
            throw new java.util.NoSuchElementException("Cannot sample an empty week2.RandomizedQueue");
        return items[StdRandom.uniform(size)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int i = 0;

        private int[] indexs;

        public RandomizedQueueIterator() {
            indexs = new int[size];
            for (int i1 = 0; i1 < size; i1++) {
                indexs[i1] = i1;
            }
            StdRandom.shuffle(indexs);
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            if(!hasNext())
                throw new java.util.NoSuchElementException("No more items in iteration.");
            return items[indexs[i++]];
        }
    }
}
