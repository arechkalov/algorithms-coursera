package com.endava.queues;


import org.junit.jupiter.api.Test;

import java.util.Iterator;

class DequeueTest {


    @Test
    void addFirst() {
        Dequeue<String> dequeue = new Dequeue<>();
        dequeue.addFirst("First");
        dequeue.addFirst("Second");
        dequeue.addFirst("Third");
        dequeue.addFirst("first1");
        dequeue.addLast("Last");
        dequeue.removeFirst();
        dequeue.removeLast();

        for (Iterator<String> iterator = dequeue.iterator(); iterator.hasNext(); ) {
            String item = iterator.next();
            System.out.println(item);
        }
    }


}
