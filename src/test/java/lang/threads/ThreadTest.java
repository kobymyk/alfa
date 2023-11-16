package lang.threads;

import org.junit.Test;

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
}
