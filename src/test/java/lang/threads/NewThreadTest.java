package lang.threads;

import org.junit.Test;

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
}
