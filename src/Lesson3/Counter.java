package Lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count;
    private Lock lock;

    public synchronized int currentValue() {
        return count;
    }

    public Counter() {
        this.lock = new ReentrantLock();
    }

    public int increment() {
        lock.lock();
        try {
            return ++count;
        } finally {
            lock.unlock();
        }
    }
}
