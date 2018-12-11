package com.endava.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Dequeue<Item> implements Iterable<Item> {

    private int size = 0;
    private Node<Item> first;
    private Node<Item> last;

    public Dequeue() {

    }

    public class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;

        public Node(Item item, Node<Item> next, Node<Item> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        Node<Item> fir = first;
        Node<Item> node = new Node<>(item, fir, null);
        first = node;
        if (fir == null) {
            last = node;
        } else {
            fir.prev = node;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        Node<Item> oldLast = last;
        Node<Item> node = new Node<>(item, null, oldLast);
        last = node;
        if (oldLast == null) {
            first = node;
        } else {
            oldLast.next = node;
        }
        size++;
    }

    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        first.prev = null;
        return item;
    }

    public Item removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Item item = last.item;
        last = last.prev;
        last.next = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> current = first;
            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void forEachRemaining(Consumer<? super Item> action) {

            }

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
