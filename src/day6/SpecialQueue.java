package day6;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SpecialQueue {
    private final Queue<String> queue;
    private final int unique;

    public SpecialQueue(int unique) {
        this.queue = new ArrayBlockingQueue<>(unique + 1);
        this.unique = unique;
    }

    public void add(String a) {
        if (this.queue.size() == this.unique) {
            String removed = this.queue.remove();
        }
        this.queue.add(a);
    }

    public boolean isUnique() {
        return this.queue.size() == this.unique && this.queue.stream().distinct().count() == this.unique;
    }
}
