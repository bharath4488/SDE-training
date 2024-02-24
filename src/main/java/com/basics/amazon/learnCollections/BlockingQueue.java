package com.basics.amazon.learnCollections;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private final Queue<Integer> q;
    private final int capacity;

    public BlockingQueue(int capacity) {
        System.out.println("Initializing queue...");
        q = new LinkedList<>();
        this.capacity  = capacity;
    }

    public boolean add(int item) {
        System.out.println("Adding item " + item);
        synchronized (q) { // for tests in LearnThreads.class
            while (q.size() == capacity) {
                /* use 'while' instead on 'if'. reason:
                   consider size 5 array, and it is filled with 4 items
                   let say t1, t2 are trying to add.
                 */
                try {
                    System.out.println("Waiting for consumer to consume...");
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            q.add(item);
            // once an element is added, we notify all waiting threads to process consuming.
            q.notifyAll();
//            System.out.println("Publisher lock released");
            return true;
        }
    }

    public int remove() {
        synchronized (q) { // for tests in LearnThreads.class
            while (q.isEmpty()) {
                // if a consumer thread gets access first, we ask it to wait, until some thread adds value to queue
                try {
                    System.out.println("waiting for producer to produce...");
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            q.notifyAll();
            int obj = q.poll();
            System.out.println("Removing item " + obj);
            return obj;
        }
    }


}
