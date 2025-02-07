package lang.threads;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    @Test
    public void start() throws InterruptedException {
        Resource resource = new Resource();
        resource.setData(3);
        new NewThread(resource).start();
        Thread thread = new NewThread(resource);
        thread.setName("Thread-B");
        thread.start();
        // Wait until thread will finish
        //thread.join();
        System.out.println(resource.getData());
        //System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void synchronizeStatic() {
        StaticResource.i = 2;
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            StaticResource.increment();
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        //
        Thread t2 = new Thread(runnable);
        t2.setName("Thread-B");
        t2.start();

        System.out.println(StaticResource.i);
    }

    @Test
    public void waitNotify() throws InterruptedException {
        Thread t = new Thread() {
            int total;

            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        total += i;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    notify();
                }
            }
        };
        t.start();
        //
        synchronized (t) {
            t.wait();
        }
    }

    @Test
    public void tryLock() {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(getName() + "start");
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
                System.out.println(getName() + "unlock");
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "start");
                while (true) {
                    if (lock.tryLock()) {
                        System.out.println(getName() + "work");
                        break;
                    } else {
                        System.out.println(getName() + "wait");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }

    @Test
    public void conditionSignal() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(getName() + "start");
                try {
                    sleep(10);
                    condition.signal();
                    System.out.println(getName() + "signal");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
                System.out.println(getName() + "unlock");
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "start");
                lock.lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(getName() + "work");
                lock.unlock();
            }
        };
        t1.start();
        t2.start();
    }
}
