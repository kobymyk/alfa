package lang.threads;

import org.junit.Test;

import java.util.function.Function;

public class NewThreadTest {
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
}
