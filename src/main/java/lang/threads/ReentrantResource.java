package lang.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantResource {
    private int data;
    private Lock lock = new ReentrantLock();

    public int getData() {
        return data;
    }

    public synchronized void setData(int data) {
        this.data = data;
    }

    public void increment() {
        lock.lock();
        int newData = data;
        if (Thread.currentThread().getName().equals("Thread-B")) {
            // Give execution to another threads
            Thread.yield();
        }
        newData++;
        lock.unlock();
        data = newData;
    }
}
