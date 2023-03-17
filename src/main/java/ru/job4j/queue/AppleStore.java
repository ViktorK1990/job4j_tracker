package ru.job4j.queue;

import java.util.List;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private List<String> xyi;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String happy = null;
        for (int i = 0; i < queue.size(); i++) {
            queue.poll();
            if ((queue.size() - count) == 0) {
               happy = queue.peek().name();
            }
        }
        return happy;
    }

    public String getFirstUpsetCustomer() {
        String upset = null;
        for (int i = 0; i < queue.size(); i++) {
            queue.poll();
            if ((queue.size() - count) < 0) {
                upset = queue.peek().name();
            }
        }
        return upset;
    }
}