package com.endava.queues;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;
    private Item[] elements;

    public RandomizedQueue() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }                       // return the number of items on the queue

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        elements[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        Random random = new Random();
        int i = random.nextInt(size);

        Item result = elements[i];
        elements[i] = elements[size - 1];
        elements[--size] = null;
        return result;
    }

    public Item sample() {
        if (isEmpty()) {
            return null;
        }
        return elements[new Random().nextInt(size)];
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }
        };
    }       // return an independent iterator over items in random order

}
