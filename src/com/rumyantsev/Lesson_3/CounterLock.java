package com.rumyantsev.Lesson_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for(int i=0; i<200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start();
        }
        Thread.sleep(1000);

        System.out.println("Counter:" + counter.getCounter());
    }
}

class Counter {
    private long counter = 0L;
    final Lock lock = new ReentrantLock();
    public void increaseCounter() {
        try {
            lock.lock();
            counter++;
        } finally {
            lock.unlock();
        }

    }

    public long getCounter() {
        return counter;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i < 1000; i++) {
            counter.increaseCounter();
        }
    }

}
