package ru.geekbrains.java.lesson3.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private long counter = 0L;
    Lock lock = new ReentrantLock();

    public void increaseCounter() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public long getCounter() {
        return counter;
    }
}
